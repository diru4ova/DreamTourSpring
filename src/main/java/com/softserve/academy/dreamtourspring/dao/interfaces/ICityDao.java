package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.City;

import java.util.List;

/**
 * Generic interface for city table access in database with custom  methods.
 *
 * @author Olena Andrushchenko
 */
public interface ICityDao extends IDao<City> {

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
     * @param name name of city to be retrieved.
     * @return City object from database connected to passed name.
     */
    City getCityByName(String name);

}
