package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IPersonDao;
import com.softserve.academy.dreamtourspring.model.Person;
import com.softserve.academy.dreamtourspring.service.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonDao personDao;

    @Override
    public List<Person> getAll() throws SQLException, NamingException {

        return personDao.getAll();
    }

    @Override
    public void add(Person person) throws SQLException, NamingException {

        personDao.add(person);
    }

    @Override
    public Person get(int id) throws SQLException, NamingException {

        return personDao.get(id);
    }

    @Override
    public void update(Person person) throws SQLException, NamingException {

        personDao.update(person);
    }

    @Override
    public void delete(int id) throws SQLException, NamingException {

        personDao.delete(id);
    }

    public Person getPersonByCredentials(String username)
            throws SQLException, NamingException {

        return personDao.getPersonByCredentials(username);
    }

}
