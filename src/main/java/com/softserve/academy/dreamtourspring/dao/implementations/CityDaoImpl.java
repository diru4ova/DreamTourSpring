package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.ICityDao;
import com.softserve.academy.dreamtourspring.model.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
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
    public List<String> getCityNameByCountry(String countryName) {



        ArrayList<String> cityList = new ArrayList<>();
       /* String query = "SELECT city_name FROM city, country WHERE country.country_name=? AND city.id_country=country.id";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, countryName);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            String cityName = set.getString("city_name");
            cityList.add(cityName);
        }
        statement.close();*/
        return cityList;
    }

    @Override
    public List<String> getAllCityNames() {
        ArrayList<String> cityList = new ArrayList<>();
        /*String query = "SELECT city_name FROM city";
        Statement statement = con.createStatement();
        ResultSet set = statement.executeQuery(query);
        while (set.next()) {
            String cityName = set.getString("city_name");
            cityList.add(cityName);
        }*/
        return cityList;
    }

    @Override
    public City getCityByName(String cityName) {
        String query = "SELECT * FROM city WHERE city_name = ?";
        City city = new City();
        /*PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, cityName);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            city.setCityId(set.getInt("id"));
            city.setCityName(set.getString("city_name"));
            city.setCountryId(set.getInt("id_country"));
        }
        statement.close();*/
        return city;
    }
}
