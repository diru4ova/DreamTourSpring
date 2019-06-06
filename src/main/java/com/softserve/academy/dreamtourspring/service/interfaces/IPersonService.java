package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.Person;

import java.util.List;

/**
 * Person service
 *
 * @author Rostyk Hlynka
 */
public interface IPersonService {

    /**
     * Find all persons
     *
     * @return list of persons
     */
    List<Person> getAll();

    /**
     * Makes given person persistent.
     *
     * @param person instance to be persisted
     */
    void add(Person person); // C

    /**
     * Find person by id.
     *
     * @param id person's id
     * @return person instance
     */
    Person get(int id); // R

    /**
     * Updates given instance.
     *
     * @param person instance to be updated
     */
    void update(Person person); // U

    /**
     * Delete person by id
     *
     * @param id person's id
     */
    void delete(int id); // D

    /**
     * Find person by username
     *
     * @param username person's username
     * @return person instance
     */
    Person getPersonByCredentials(String username);
}
