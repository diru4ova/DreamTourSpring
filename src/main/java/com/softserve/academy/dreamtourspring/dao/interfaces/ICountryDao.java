package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.Country;

import java.util.List;

/**
 * Generic interface for country table access in database with custom  methods.
 *
 * @author Olena Andrushchenko
 */

public interface ICountryDao extends IDao<Country> {
    /**
     * retrieves the list of countries that person has visited.
     *
     * @return list of all countries names that person has been to.
     */
    List<String> getCountryNameByPerson(int personId);

    /**
     * retrieves the list of all countries names.
     *
     * @return list of all countries names that agency works with.
     */
    List<String> getAllNames();

    /**
     * retrieves Country object from database connected to passed country name.
     *
     * @param countryName of country to be retrieved.
     * @return Country object from database connected to passed country name.
     */
    Country getCountryByName(String countryName);

}
