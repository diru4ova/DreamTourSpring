package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.City;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface ICityService {

    List<City> getAll() throws SQLException, NamingException;

    void add(City city) throws SQLException, NamingException; // C

    City get(int id) throws SQLException, NamingException; // R

    void update(City city) throws SQLException, NamingException; // U

    void delete(int id) throws SQLException, NamingException; // D

    List<String> getCityNameByCountry(String countryName) throws SQLException, NamingException;

}
