package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.ICityDao;
import com.softserve.academy.dreamtourspring.model.City;
import com.softserve.academy.dreamtourspring.service.interfaces.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * implementation of ICityService interface for performing business logic and access to DAO layer associated with City object.
 *
 * @author Olena Andrushchenko
 */
@Service
@Transactional
public class CityServiceImpl implements ICityService {

    @Autowired
    ICityDao dao;

    /**
     * @return list of cities.
     */
    @Override
    public List<City> getAll() {
        return dao.getAll();
    }

    /**
     * adds a city object to the table in database.
     *
     * @param city an object to be injected into database table.
     */
    @Override
    public void add(City city) {
        dao.add(city);
    }

    /**
     * returns an object by id.
     *
     * @param id of object to be retrieved.
     * @return City from table in database.
     */
    @Override
    public City get(int id) {
        return dao.get(id);
    }

    /**
     * updates a record in database connected to passed object
     *
     * @param city City object to be updated
     */
    @Override
    public void update(City city) {
        dao.update(city);
    }

    /**
     * removes a record from database connected to passed id
     *
     * @param id of object to be removed
     */
    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    /**
     * retrieves the list of cities in specified country.
     *
     * @param countryName name of country.
     * @return list of cities in country passed as parameter.
     */
    @Override
    public List<String> getCityNameByCountry(String countryName) throws IllegalArgumentException {
        return dao.getCityNameByCountry(countryName);
    }

    /**
     * retrieves the list of all cities.
     *
     * @return list of all cities that agency works with.
     */
    @Override
    public List<String> getAllCityNames() {
        return dao.getAllCityNames();
    }

    /**
     * retrieves City object from database by connected to passed city name.
     *
     * @param cityName of city to be retrieved.
     * @return City object from database connected to passed name.
     */
    @Override
    public City getCityByName(String cityName)throws IllegalArgumentException {
        return dao.getCityByName(cityName);
    }
}
