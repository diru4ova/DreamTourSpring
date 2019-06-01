package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.ICountryDao;
import com.softserve.academy.dreamtourspring.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CountryDaoImpl implements ICountryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Country> getAll() {

        /*CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Country> criteria = builder.createQuery(Country.class);
        criteria.from(Country.class);
        List<Country> countryList = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();*/

        List<Country> countryList = sessionFactory.getCurrentSession().createQuery("from City").list();

        return countryList;
    }

    @Override
    public void add(Country country) {
    }

    @Override
    public Country get(int id) {
        Country country = sessionFactory.getCurrentSession().get(Country.class, id);
        return country;
    }

    @Override
    public void update(Country country) {
        sessionFactory.getCurrentSession().update(country);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Country.class, id));
    }

    @Override
    public List<String> getCountryNameByPerson(int personId) {
        List<String> countryList;
        Query query = sessionFactory.getCurrentSession().createQuery("select c.countryName "
                 + "from Country c, Booking b where b.country.countryId=c.countryId and b.person =:personId");
        query.setParameter("personId", personId);
        countryList = query.list();
        return countryList;
    }

    @Override
    public List<String> getAllNames() {

        List<String> countryNameList;
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT c.countryName FROM Country c");
        countryNameList = query.list();
        return countryNameList;
    }

    public Country getCountryByName(String countryName) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Country where countryName=:name").setParameter("name", countryName);
        Country country = (Country) query.uniqueResult();
        return country;
    }

}
