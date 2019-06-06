package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.Person;

/**
 * Person dao
 *
 * @author Rostyk Hlynka
 */
public interface IPersonDao extends IDao<Person> {

    /**
     * Find person by username
     * @param username person's username
     * @return person instance
     */
    Person getPersonByCredentials(String username);
}
