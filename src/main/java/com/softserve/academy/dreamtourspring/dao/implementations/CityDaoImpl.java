package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.ICityDao;
import com.softserve.academy.dreamtourspring.model.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository class for City entity.
 *
 * @author Olena Andrushchenko
 */

@Repository
public class CityDaoImpl implements ICityDao {
    /**
     * Global object for creating sessions.
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Find all City entities.
     *
     * @return list of City objects.
     */
    @Override
    public List<City> getAll() {

        List<City> cityList = sessionFactory.getCurrentSession().createQuery("from City").list();
        return cityList;
    }

    /**
     * Persist given City object.
     *
     * @param city entity that need to be persisted.
     */
    @Override
    public void add(City city) {
        sessionFactory.getCurrentSession().save(city);
    }

    /**
     * Retrieves City object with given id.
     *
     * @param id city id.
     * @return City object associted with give id.
     */
    @Override
    public City get(int id) {
        City city = sessionFactory.getCurrentSession().get(City.class, id);
        return city;
    }

    /**
     * Updates a record associated with give City object.
     *
     * @param city City object to be updated.
     */
    @Override
    public void update(City city) {
        sessionFactory.getCurrentSession().update(city);
    }

    /**
     * Removes City record associated with given id.
     *
     * @param id of entity to be removed.
     */
    @Override
    public void delete(int id) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(City.class, id));
    }

    /**
     * Gets list of cities names connected with given country.
     *
     * @param countryName name of country.
     * @return list of cities names.
     */
    @Override
    public List<String> getCityNameByCountry(String countryName) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT city.cityName FROM City city, Country country"
                        + " WHERE country.countryName=:countryName"
                        + " AND city.country.countryId=country.id");
        query.setParameter("countryName", countryName);
        List<String> cityList = query.list();

        return cityList;
    }

    /**
     * Gets names of all cities existing.
     *
     * @return list of cities names that company works with.
     */
    @Override
    public List<String> getAllCityNames() {

        List<String> cityNames;
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT c.cityName FROM City c");
        cityNames = query.list();
        return cityNames;
    }

    /**
     * Gets City object with given name.
     *
     * @param cityName city name to be found.
     * @return City object associated with given name.
     */
    @Override
    public City getCityByName(String cityName) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from City c where c.cityName=:name");
        query.setParameter("name", cityName);
        City city = (City) query.uniqueResult();
        return city;
    }
}
