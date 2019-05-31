package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.ICityDao;
import com.softserve.academy.dreamtourspring.model.City;
import com.softserve.academy.dreamtourspring.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class CityDaoImpl implements ICityDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<City> getAll() {

        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<City> criteria = builder.createQuery(City.class);
        criteria.from(City.class);
        List<City> cityList = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();

/*        List<City> cityList = sessionFactory.getCurrentSession().createQuery("SELECT c FROM city c", City.class).getResultList();
        sessionFactory.getCurrentSession().createQuery("from City").list();*/

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
        //session.remove(id);
    }

    @Override
    public List<City> getCityNameByCountry(String countryName) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Country where countryName=:name").setParameter("name", countryName);
        Country country = (Country) query.uniqueResult();
        List<City> cityList = country.getCityList();

        return cityList;
    }

    @Override
    public List<String> getAllCityNames() {
        List<City> cityList = getAll();
        List<String> cityNames = null;
        for (City city : cityList) {
            cityNames.add(city.getCityName());
        }
        return cityNames;
    }

    @Override
    public City getCityByName(String cityName) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from City where cityName=:name").setParameter("name", cityName);
        City city = (City) query.uniqueResult();
        return city;
    }
}
