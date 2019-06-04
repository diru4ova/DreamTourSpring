package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.implementations.VisaDaoImpl;
import com.softserve.academy.dreamtourspring.dao.interfaces.IVisaDao;
import com.softserve.academy.dreamtourspring.model.Country;
import com.softserve.academy.dreamtourspring.model.Person;
import com.softserve.academy.dreamtourspring.model.Visa;
import com.softserve.academy.dreamtourspring.service.interfaces.IVisaService;
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

import static org.mockito.Mockito.when;


// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class VisaServiceImplTest {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    private IVisaService visaService = new VisaServiceImpl();

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    private IVisaDao visaDao = new VisaDaoImpl();

    private List<Visa> visaList;

    @Before
    public void init() {

        visaList = new ArrayList<Visa>() {{
            add(new Visa(3, LocalDate.parse("2015-12-09"), new Person(), new Country()));
            add(new Visa(4, LocalDate.parse("2015-11-08"), new Person(), new Country()));
            add(new Visa(5, LocalDate.parse("2015-10-07"), new Person(), new Country()));
            add(new Visa(6, LocalDate.parse("2015-09-06"), new Person(), new Country()));
            add(new Visa(7, LocalDate.parse("2015-08-05"), new Person(), new Country()));
            add(new Visa(8, LocalDate.parse("2015-07-04"), new Person(), new Country()));
        }};
    }

    @After
    public void destroy() {
        visaService = null;
        visaDao = null;
        visaList = null;
    }

    @Test
    public void getAllifListNotEmpty() {

        when(visaDao.getAll()).thenReturn(visaList);

        int expectedId = 4;
        Assert.assertEquals(visaService.getAll().get(1).getId(), expectedId);
    }

    @Test
    public void getAllifListIsEmpty() {

        List<Visa> emptyList = new ArrayList<>();

        when(visaDao.getAll()).thenReturn(emptyList);
        Assert.assertEquals(visaService.getAll(), emptyList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getIdVisaByCountryByDateWithInvalidArguments() {

        int personId = 2;
        int countryId = 3;
        LocalDate endDate = null;

        visaService.getIdVisaByCountryByDate(personId, countryId, endDate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWithInvalidArguments() {

        LocalDate endDate = null;
        Person person = null;
        Country country = null;
        Visa visa = new Visa(endDate, person, country);

        visaService.add(visa);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateWithInvalidArguments() {

        LocalDate endDate = null;
        Person person = null;
        Country country = null;
        Visa visa = new Visa(endDate, person, country);

        visaService.update(visa);
    }

    @Test(expected = IllegalArgumentException.class)
    public void hasVisaWithInvalidArguments() {

        int idPerson = 1;
        int idCountry = 1;
        LocalDate endDate = null;

        visaService.hasVisa(idPerson, idCountry, endDate);
    }

}