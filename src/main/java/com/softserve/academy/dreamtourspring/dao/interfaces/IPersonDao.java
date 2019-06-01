package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.Person;


public interface IPersonDao extends IDao<Person> {

    Person getPersonByCredentials(String username);
}
