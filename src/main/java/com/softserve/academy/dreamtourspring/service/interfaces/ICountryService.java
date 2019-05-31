package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.Country;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface ICountryService {

    List<Country> getAll() throws SQLException, NamingException;

    void add(Country country) throws SQLException, NamingException; // C

    Country get(int id) throws SQLException, NamingException; // R

    void update(Country country) throws SQLException, NamingException; // U

    void delete(int id) throws SQLException, NamingException; // D

    List<String> getCountryNameByPerson(int personId) throws SQLException;

    List<String> getAllNames() throws SQLException;

}
