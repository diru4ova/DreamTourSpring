package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IVisaDao;
import com.softserve.academy.dreamtourspring.model.Visa;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class VisaDaoImpl implements IVisaDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Visa> getAll() {

        return sessionFactory.getCurrentSession().createQuery("from Visa").list();
    }

    @Override
    public int getVisaCountByCountryForPerson(String countryName, int idPerson) {
        Query query = sessionFactory.getCurrentSession().createQuery("select count(id) from Visa"
            + " where country.countryId=(select id from Country where countryName=:countryName)"
            + " and person.id=:idPerson");

        query.setParameter("idPerson", idPerson);
        query.setParameter("countryName", countryName);

        return (Integer)query.getSingleResult();
    }

    public void add(Visa visa) {

        sessionFactory.getCurrentSession().persist(visa);
    }

    public Visa get(int id) {

        return sessionFactory.getCurrentSession().get(Visa.class, id);
    }

    public void update(Visa visa) {

        sessionFactory.getCurrentSession().update(visa);
    }

    public void delete(int id) {

        sessionFactory.getCurrentSession().remove(id);
    }

    @Override
    public List<Visa> getAllVisaByPerson(int idPerson) {

       Query<Visa> query = sessionFactory.getCurrentSession()
               .createQuery("from Visa where person.id=:idPerson")
               .setParameter("idPerson", idPerson);

       List<Visa> visaList = query.list();

       return visaList;
    }

    @Override
    public int getIdVisaByCountryByDate(int personId, int countryId, LocalDate endDate) {
        Visa visa = new Visa();
        try {
            Query query = sessionFactory.getCurrentSession().createQuery("from Visa "
                + "where person.id=:personId AND country.countryId=:countryId"
                + " AND endDate=:endDate");

            query.setParameter("personId", personId);
            query.setParameter("countryId", countryId);
            query.setParameter("endDate", endDate);
            visa = (Visa)query.getSingleResult();
        } catch (NullPointerException e) {
            visa.setId(0);
        }

        return visa.getId();
    }
}
