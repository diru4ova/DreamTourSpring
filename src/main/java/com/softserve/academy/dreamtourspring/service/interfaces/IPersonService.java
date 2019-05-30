package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtour.entity.Person;
import com.softserve.academy.dreamtourspring.model.Person;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface IPersonService {

    List<Person> getAll() throws SQLException, NamingException;

    boolean add(Person person) throws SQLException, NamingException; // C

    Person get(int id) throws SQLException, NamingException; // R

    boolean update(Person person) throws SQLException, NamingException; // U

    boolean delete(int id) throws SQLException, NamingException; // D

    Person getPersonByCredentials(String username) throws SQLException, NamingException;
}
