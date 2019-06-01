package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.ICityDao;
import com.softserve.academy.dreamtourspring.model.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityDaoImpl implements ICityDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<City> getAll() {

        List<City> cityList = sessionFactory.getCurrentSession().createQuery("from City").list();
        return cityList;
    }

    @Override
    public void add(City city) {
        sessionFactory.getCurrentSession().save(city);
    }

    @Override
    public City get(int id) {
        City city = sessionFactory.getCurrentSession().get(City.class, id);
        return city;
    }

    @Override
    public void update(City city) {
        sessionFactory.getCurrentSession().update(city);
    }

    @Override
    public void delete(int id) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(City.class, id));
    }

    @Override
    public List<String> getCityNameByCountry(String countryName) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT city.cityName FROM City city, Country country WHERE country.countryName=:countryName" +
                        " AND city.country.countryId=country.id");
        query.setParameter("countryName", countryName);
        List<String> cityList = query.list();

        return cityList;
    }

    @Override
    public List<String> getAllCityNames() {

        List<String> cityNames;
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT c.cityName FROM City c");
        cityNames = query.list();
        return cityNames;
    }

    @Override
    public City getCityByName(String cityName) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from City where cityName=:name");
        query.setParameter("name", cityName);
        City city = (City) query.uniqueResult();
        return city;
    }
}
