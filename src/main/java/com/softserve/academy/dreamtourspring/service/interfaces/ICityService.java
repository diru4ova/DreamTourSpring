package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.City;

import java.util.List;

/**
 * Interface for performing business logic and access to DAO layer associated with City object.
 *
 * @author Olena Andrushchenko
 */
public interface ICityService {
    /**
     * @return element's list of specified type.
     */
    List<City> getAll();

    /**
     * adds an object of specified type to the table in database.
     *
     * @param city an object to be injected into database table.
     */
    void add(City city); // C

    /**
     * returns an object by id.
     *
     * @param id of object to be retrieved.
     * @return an object of specified type from table in database.
     */
    City get(int id); // R
    /**
     * updates a record in database connected to passed object
     *
     * @param city object to be updated
     */
    void update(City city); // U
    /**
     * removes a record from database connected to passed id
     *
     * @param id of object to be removed
     */
    void delete(int id); // D

    /**
     * retrieves the list of cities in specified country.
     *
     * @param countryName name of country.
     * @return list of cities in country passed as parameter.
     */
    List<String> getCityNameByCountry(String countryName);

    /**
     * retrieves the list of all cities.
     *
     * @return list of all cities that agency works with.
     */
    List<String> getAllCityNames();

    /**
     * retrieves City object from database by connected to passed city name.
     *
     * @param cityName of city to be retrieved.
     * @return City object from database connected to passed name.
     */
    City getCityByName(String cityName);

}
