package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.ICountryDao;
import com.softserve.academy.dreamtourspring.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryDaoImpl implements ICountryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Country> getAll() {

        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Country> criteria = builder.createQuery(Country.class);
        criteria.from(Country.class);
        List<Country> countryList = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();

/*        List<City> cityList = sessionFactory.getCurrentSession().createQuery("SELECT c FROM city c", City.class).getResultList();
        sessionFactory.getCurrentSession().createQuery("from City").list();*/
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
        //session.remove(id);
    }

    @Override
    public List<String> getCountryNameByPerson(int personId) {
        ArrayList<String> countryList = new ArrayList<>();
       /* String query = "select country.country_name \n" + "from country, booking \n"
                + "where booking.id_country=country.id and booking.id_tourist =?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, personId);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            String countryName = set.getString("country_name");
            countryList.add(countryName);
        }*/
        return countryList;
    }

    @Override
    public List<String> getAllNames() {

        String hql = "select countryName from Country";
        Query query = sessionFactory.getCurrentSession().createQuery(hql,String.class);

        List<String> countryNameList = query.getResultList();

        return countryNameList;
    }

    public Country getCountryByName(String countryName) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Country where countryName=:name").setParameter("name", countryName);
        Country country = (Country) query.uniqueResult();
        return country;
    }

}