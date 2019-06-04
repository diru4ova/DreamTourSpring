package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IPersonDao;
import com.softserve.academy.dreamtourspring.model.Person;
import com.softserve.academy.dreamtourspring.service.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Person service implementation
 *
 * @author Rostyk Hlynka
 */
@Service
@Transactional
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonDao personDao;

    /**
     * Find all persons
     *
     * @return list of persons
     */
    @Override
    public List<Person> getAll() {

        return personDao.getAll();
    }

    /**
     * Makes given person persistent.
     *
     * @param person instance to be persisted
     */
    @Override
    public void add(Person person) throws IllegalArgumentException {

        if (person.getFirstName() == null || person.getLastName() == null
                || person.getUsername() == null || person.getPassword() == null) {

            throw new IllegalArgumentException("person is not completed!");
        }

        personDao.add(person);
    }

    /**
     * Find person by id.
     *
     * @param id person's id
     * @return person instance
     */
    @Override
    public Person get(int id) {

        return personDao.get(id);
    }

    /**
     * Updates given instance.
     *
     * @param person instance to be updated
     */
    @Override
    public void update(Person person) throws IllegalArgumentException {

        if (person.getFirstName() == null || person.getLastName() == null
                || person.getUsername() == null || person.getPassword() == null) {

            throw new IllegalArgumentException("person is not completed!");
        }

        personDao.update(person);
    }

    /**
     * Delete person by id
     *
     * @param id person's id
     */
    @Override
    public void delete(int id) {

        personDao.delete(id);
    }

    /**
     * Find person by username
     *
     * @param username person's username
     * @return person instance
     */
    public Person getPersonByCredentials(String username) throws IllegalArgumentException {

        if (username == null) {

            throw new IllegalArgumentException("username can't be null!");
        }

        return personDao.getPersonByCredentials(username);
    }

}
