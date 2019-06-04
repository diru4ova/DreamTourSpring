package com.softserve.academy.dreamtourspring.dao.interfaces;

import java.util.List;

/**
 * Generic interface for database access via CRUD operations.
 */
public interface IDao<T> {
    /**
     * @return element's list of specified type.
     */
    List<T> getAll();

    /**
     * adds an object of specified type to the table in database.
     *
     * @param t an object to be injected into database table.
     */
    void add(T t); // C

    /**
     * returns an object by id.
     *
     * @param id of object to be retrieved.
     * @return an object of specified type from table in database.
     */
    T get(int id); // R

    /**
     * updates a record in database connected to passed object
     *
     * @param t object to be updated
     */
    void update(T t); // U

    /**
     * removes a record from database connected to passed id
     *
     * @param id of object to be removed
     */
    void delete(int id); // D

}
