package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IPersonDao;
import com.softserve.academy.dreamtourspring.model.Person;
import com.softserve.academy.dreamtourspring.service.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonDao personDao;

    @Override
    public List<Person> getAll() {

        return personDao.getAll();
    }

    @Override
    public void add(Person person) {

        personDao.add(person);
    }

    @Override
    public Person get(int id) {

        return personDao.get(id);
    }

    @Override
    public void update(Person person) {

        personDao.update(person);
    }

    @Override
    public void delete(int id) {

        personDao.delete(id);
    }

    public Person getPersonByCredentials(String username) {

        return personDao.getPersonByCredentials(username);
    }

}
