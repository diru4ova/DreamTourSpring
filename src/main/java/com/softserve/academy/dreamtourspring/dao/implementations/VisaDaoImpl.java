package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IVisaDao;
import com.softserve.academy.dreamtourspring.model.Visa;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Visa dao implementation
 *
 * @author Rostyk Hlynka
 */
@Repository
public class VisaDaoImpl implements IVisaDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Find all instances of visa
     *
     * @return list of instances
     */
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

        return (Integer) query.getSingleResult();
    }

    /**
     * Makes given instance persistent.
     *
     * @param visa instance to be persisted
     */
    public void add(Visa visa) {

        sessionFactory.getCurrentSession().persist(visa);
    }

    /**
     * Find visa by id
     *
     * @param id visa's id
     * @return found visa
     */
    public Visa get(int id) {

        return sessionFactory.getCurrentSession().get(Visa.class, id);
    }

    /**
     * Update given visa.
     *
     * @param visa instance to be updated
     */
    public void update(Visa visa) {

        sessionFactory.getCurrentSession().update(visa);
    }

    /**
     * Delete visa by id
     *
     * @param id visa's id
     */
    public void delete(int id) {

        sessionFactory.getCurrentSession().remove(id);
    }

    /**
     * Find visas by person
     *
     * @param idPerson person's id
     * @return list of visa
     */
    @Override
    public List<Visa> getAllVisaByPerson(int idPerson) {

        Query<Visa> query = sessionFactory.getCurrentSession()
                .createQuery("from Visa where person.id=:idPerson")
                .setParameter("idPerson", idPerson);

        List<Visa> visaList = query.list();

        return visaList;
    }

    /**
     * Check if person can book tour
     *
     * @param personId  person's id
     * @param countryId country's id
     * @param endDate   end date of tour
     * @return visa's id
     */
    @Override
    public int getIdVisaByCountryByDate(int personId, int countryId, LocalDate endDate) {
        Query query = sessionFactory.getCurrentSession().createQuery("select id from Visa "
                + "where Person.id=:personId AND Country.countryId=:countryId"
                + " AND endDate=:endDate");

        query.setParameter("personId", personId);
        query.setParameter("countryId", countryId);
        query.setParameter("endDate", endDate);

        return (Integer) query.getSingleResult();
    }
}
