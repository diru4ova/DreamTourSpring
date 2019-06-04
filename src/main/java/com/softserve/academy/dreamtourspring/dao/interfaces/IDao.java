package com.softserve.academy.dreamtourspring.dao.interfaces;

import java.util.List;

/**
 * General dao
 *
 * @param <T> type of generic
 * @author Rostyk Hlynka
 */
public interface IDao<T> {

    /**
     * Find all instances of generic
     *
     * @return list of instances
     */
    List<T> getAll();

    /**
     * Makes given instance persistent.
     *
     * @param t instance to be persisted
     */
    void add(T t); // C

    /**
     * returns an object by id.
     *
     * @param id instance's id
     * @return found instance
     */
    T get(int id); // R

    /**
     * Update given instance.
     *
     * @param t instance to be updated
     */
    void update(T t); // U

    /**
     * Delete instance by id
     *
     * @param id instance's id
     */
    void delete(int id); // D

}
