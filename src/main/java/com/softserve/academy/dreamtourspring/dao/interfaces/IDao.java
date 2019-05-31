package com.softserve.academy.dreamtourspring.dao.interfaces;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

    List<T> getAll() throws SQLException, NamingException;

    void add(T t) throws SQLException, NamingException; // C

    T get(int id) throws SQLException, NamingException; // R

    void update(T t) throws SQLException, NamingException; // U

    void delete(int id) throws SQLException, NamingException; // D

}
