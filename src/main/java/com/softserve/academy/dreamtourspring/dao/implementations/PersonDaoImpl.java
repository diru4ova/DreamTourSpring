package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IPersonDao;
import com.softserve.academy.dreamtourspring.model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public class PersonDaoImpl implements IPersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Person> getAll() throws SQLException, NamingException {
        return sessionFactory.getCurrentSession().createQuery("from Person").list();
    }

    @Override
    public void add(Person person) throws SQLException, NamingException {
        sessionFactory.getCurrentSession().persist(person);
    }

    @Override
    public Person get(int id) throws SQLException, NamingException {
        return sessionFactory.getCurrentSession().get(Person.class, id);
    }

    @Override
    public void update(Person person) throws SQLException, NamingException {

        sessionFactory.getCurrentSession().update(person);
    }

    @Override
    public void delete(int id) throws SQLException, NamingException {

        sessionFactory.getCurrentSession().remove(id);
    }

    @Override
    public Person getPersonByCredentials(String username) throws SQLException, NamingException {

        return null;
    }
}
