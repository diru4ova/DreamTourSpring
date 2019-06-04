package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IPersonDao;
import com.softserve.academy.dreamtourspring.model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Person dao implementation
 *
 * @author Rostyk Hlynka
 */
@Repository
public class PersonDaoImpl implements IPersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Find all instances of person
     * @return list of instances
     */
    @Override
    public List<Person> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Person").list();
    }

    /**
     * Makes given instance persistent.
     * @param person instance to be persisted
     */
    @Override
    public void add(Person person) {
        sessionFactory.getCurrentSession().persist(person);
    }

    /**
     * Find person by id
     * @param id person's id
     * @return found person
     */
    @Override
    public Person get(int id) {
        return sessionFactory.getCurrentSession().get(Person.class, id);
    }

    /**
     * Update given person.
     * @param person instance to be updated
     */
    @Override
    public void update(Person person) {

        sessionFactory.getCurrentSession().update(person);
    }

    /**
     * Delete person by id
     *
     * @param id person's id
     */
    @Override
    public void delete(int id) {

        sessionFactory.getCurrentSession().remove(id);
    }

    /**
     * Find person by username
     *
     * @param username person's username
     * @return person instance
     */
    @Override
    public Person getPersonByCredentials(String username) {

        Query<Person> query = sessionFactory.getCurrentSession()
                .createQuery("from Person where username=:username")
                .setParameter("username", username);

        List<Person> personList = query.list();
        Person person = null;
        if(!personList.isEmpty()){
            // ignores multiple results
            person = personList.get(0);
        }
        return person;
    }
}
