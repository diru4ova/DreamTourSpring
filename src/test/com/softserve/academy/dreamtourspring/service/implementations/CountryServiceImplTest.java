package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.implementations.CountryDaoImpl;
import com.softserve.academy.dreamtourspring.dao.interfaces.ICountryDao;
import com.softserve.academy.dreamtourspring.model.Country;
import com.softserve.academy.dreamtourspring.service.interfaces.ICountryService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CountryServiceImplTest {
    @InjectMocks
    private ICountryService countryService = new CountryServiceImpl();
    @Mock
    private ICountryDao countryDao = new CountryDaoImpl();

    private ArrayList<Country> countryList;

    @Before
    public void init() {

        countryList = new ArrayList<Country>() {{
            add(new Country(40, "Turkey"));
            add(new Country(41, "France"));
            add(new Country(42, "China"));
            add(new Country(43, "USA"));

        }};
    }

    @After
    public void destroy() {
        countryService = null;
        countryDao = null;
        countryList = null;
    }

    @Test//(expected = IllegalArgumentException.class)
    public void getCountryNameByWrongPerson() {
        int personId = 10;
        countryService.getCountryNameByPerson(personId);
    }

    @Test
    public void getAllNamesIfListEmpty() {
        List<Country> emptyList = new ArrayList<>();

        when(countryDao.getAll()).thenReturn(emptyList);
        Assert.assertEquals(countryService.getAllNames(), emptyList);
    }

    @Test
    public void getCountryByName() {

        String countryName = null;

        countryService.getCountryByName(countryName);

    }
}