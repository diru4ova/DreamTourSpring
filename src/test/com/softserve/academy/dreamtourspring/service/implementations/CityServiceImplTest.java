package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.implementations.CityDaoImpl;
import com.softserve.academy.dreamtourspring.dao.interfaces.ICityDao;
import com.softserve.academy.dreamtourspring.model.City;
import com.softserve.academy.dreamtourspring.model.Country;
import com.softserve.academy.dreamtourspring.service.interfaces.ICityService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CityServiceImplTest {
    @InjectMocks
    private ICityService cityService = new CityServiceImpl();
    @Mock
    private ICityDao cityDao = new CityDaoImpl();

    private ArrayList<City> cityList;


    @Before
    public void init() {

        cityList = new ArrayList<City>() {{
            add(new City(40, "Paris", new Country(1,"France")));
            add(new City(41, "Istanbul", new Country(2,"Turkey")));
            add(new City(42, "Miami", new Country(3,"USA")));
            add(new City(43, "Beijing", new Country(4, "China")));

        }};
    }

    @After
    public void destroy() {
        cityService = null;
        cityDao = null;
        cityList = null;
    }

    @Test//(expected = IllegalArgumentException.class)
    public void getCityNameIfCountryNotExist() {

        cityService.getCityNameByCountry("England");
    }

    @Test
    public void getAllCityNamesIfListNull() {
        ArrayList<City> emptyList = new ArrayList<>();
        when(cityDao.getAll()).thenReturn(emptyList);
        Assert.assertEquals(cityService.getAll(), emptyList);
    }

    @Test//(expected = IllegalArgumentException.class)
    public void getCityByNameIfNameEmpty() {
        String cityName = null;

        cityService.getCityByName(cityName);

    }
}