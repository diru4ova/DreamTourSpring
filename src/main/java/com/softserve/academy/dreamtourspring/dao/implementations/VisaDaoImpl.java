package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IVisaDao;
import com.softserve.academy.dreamtourspring.model.Visa;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class VisaDaoImpl implements IVisaDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Visa> getAll() {

        return sessionFactory.getCurrentSession().createQuery("from Visa").list();
    }

    @Override
    public int getVisaCountByCountryForPerson(String countryName, int idPerson) {

        return 0;
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

       Query query = sessionFactory.getCurrentSession()
               .createQuery("from Visa where id_tourist:=idPerson",Visa.class)
               .setParameter("idPerson", idPerson);

       List<Visa> visaList = query.getResultList();

       return visaList;
    }

    @Override
    public int getIdVisaByCountryByDate(int personId, int countryId, LocalDate endDate) {

        return 0;
    }
}
