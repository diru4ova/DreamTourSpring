package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.implementations.PersonDaoImpl;
import com.softserve.academy.dreamtourspring.dao.interfaces.IPersonDao;
import com.softserve.academy.dreamtourspring.enums.PersonType;
import com.softserve.academy.dreamtourspring.model.Country;
import com.softserve.academy.dreamtourspring.model.Person;
import com.softserve.academy.dreamtourspring.model.Visa;
import com.softserve.academy.dreamtourspring.service.interfaces.IPersonService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class PersonServiceImplTest {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    private IPersonService personService = new PersonServiceImpl();

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    private IPersonDao personDao = new PersonDaoImpl();

    private List<Person> personList;

    @Before
    public void init() {

        personList = new ArrayList<Person>() {{
            add(new Person(3, "username", "pass",
                    "firstName", "lastName", PersonType.USER));
            add(new Person(4, "username", "pass",
                    "firstName", "lastName", PersonType.USER));
            add(new Person(5, "username", "pass",
                    "firstName", "lastName", PersonType.USER));
        }};
    }

    @After
    public void destroy() {
        personService = null;
        personDao = null;
        personList = null;
    }

    @Test
    public void getAllifListNotEmpty() {

        when(personDao.getAll()).thenReturn(personList);

        int expectedId = 4;
        Assert.assertEquals(personService.getAll().get(1).getId(), expectedId);
    }

    @Test
    public void getAllifListIsEmpty() {

        List<Person> emptyList = new ArrayList<>();

        when(personDao.getAll()).thenReturn(emptyList);
        Assert.assertEquals(personService.getAll(), emptyList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWithInvalidArguments() {

        Person person = new Person("person", "person",
                null, "pass", PersonType.USER);

        personService.add(person);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateWithInvalidArguments() {

        Person person = new Person("person", "person",
                null, "pass", PersonType.USER);

        personService.update(person);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getPersonByCredentialsWithInvalidArguments() {

        String username = null;

        personService.getPersonByCredentials(username);
    }
}