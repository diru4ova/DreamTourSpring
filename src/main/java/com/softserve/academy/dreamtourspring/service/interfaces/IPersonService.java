package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.Person;

import java.util.List;

public interface IPersonService {

    List<Person> getAll();

    void add(Person person); // C

    Person get(int id); // R

    void update(Person person); // U

    void delete(int id); // D

    Person getPersonByCredentials(String username);
}
