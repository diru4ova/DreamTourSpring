package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.City;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface ICityDao extends IDao<City> {

    List<City> getCityNameByCountry(String countryName) throws SQLException, NamingException;

    List <String> getAllCityNames() throws SQLException, NamingException;

    City getCityByName (String name)throws SQLException, NamingException;

}
