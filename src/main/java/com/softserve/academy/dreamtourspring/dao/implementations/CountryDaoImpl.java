package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.ICountryDao;
import com.softserve.academy.dreamtourspring.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository class for Country entity.
 *
 * @author Olena Andrushchenko
 */
@Repository
public class CountryDaoImpl implements ICountryDao {
    /**
     * Global object for creating sessions.
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Find all Country entities.
     *
     * @return list of Country objects.
     */
    @Override
    public List<Country> getAll() {

        List<Country> countryList = sessionFactory.getCurrentSession().createQuery("from Country").list();
        return countryList;
    }

    /**
     * Persist given Country object.
     *
     * @param country entity that need to be persisted.
     */
    @Override
    public void add(Country country) {
    }

    /**
     * Retrieves Country object with given id.
     *
     * @param id country id.
     * @return Country object associted with give id.
     */
    @Override
    public Country get(int id) {
        Country country = sessionFactory.getCurrentSession().get(Country.class, id);
        return country;
    }

    /**
     * Updates a record associated with give Country object.
     *
     * @param country Country object to be updated.
     */
    @Override
    public void update(Country country) {
        sessionFactory.getCurrentSession().update(country);
    }

    /**
     * Removes Country record associated with given id.
     *
     * @param id of entity to be removed.
     */
    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Country.class, id));
    }

    /**
     * retrieves the list of countries that person has visited.
     *
     * @return list of all countries names that person has been to.
     */
    @Override
    public List<String> getCountryNameByPerson(int personId) {

        List<String> countryList;
        Query query = sessionFactory.getCurrentSession().createQuery("select c.countryName "
                + "from Country c, Booking b where b.country.countryId=c.countryId and b.person =:personId");
        query.setParameter("personId", personId);
        countryList = query.list();
        return countryList;
    }

    /**
     * retrieves the list of all countries names.
     *
     * @return list of all countries names that agency works with.
     */
    @Override
    public List<String> getAllNames() {

        String hql = "select countryName from Country";
        Query query = sessionFactory.getCurrentSession().createQuery(hql, String.class);
        List<String> countryNameList = query.getResultList();
        return countryNameList;
    }

    /**
     * retrieves Country object from database connected to passed country name.
     *
     * @param countryName of country to be retrieved.
     * @return Country object from database connected to passed country name.
     */
    public Country getCountryByName(String countryName) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Country where countryName=:name").setParameter("name", countryName);
        Country country = (Country) query.uniqueResult();
        return country;
    }

}