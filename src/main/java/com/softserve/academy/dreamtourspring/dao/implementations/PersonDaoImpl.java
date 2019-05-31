package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IPersonDao;
import com.softserve.academy.dreamtourspring.model.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PersonDaoImpl implements IPersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Person> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Person").list();
    }

    @Override
    public void add(Person person) {
        sessionFactory.getCurrentSession().persist(person);
    }

    @Override
    public Person get(int id) {
        return sessionFactory.getCurrentSession().get(Person.class, id);
    }

    @Override
    public void update(Person person) {

        sessionFactory.getCurrentSession().update(person);
    }

    @Override
    public void delete(int id) {

        sessionFactory.getCurrentSession().remove(id);
    }

    @Override
    public Person getPersonByCredentials(String username) {

        return null;
    }
}
