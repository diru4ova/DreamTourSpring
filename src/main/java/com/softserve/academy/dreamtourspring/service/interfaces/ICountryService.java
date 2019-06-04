package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.Country;

import java.util.List;

/**
 * Interface for performing business logic and access to DAO layer associated with Country object.
 *
 * @author Olena Andrushchenko
 */
public interface ICountryService {
    /**
     * @return list of countries.
     */
    List<Country> getAll();

    /**
     * adds a Country object to the table in database.
     *
     * @param country an object to be injected into database table.
     */
    void add(Country country); // C

    /**
     * returns Country object by id.
     *
     * @param id of country to be retrieved.
     * @return Country object  from table in database.
     */
    Country get(int id); // R

    /**
     * updates a record in database connected to passed object
     *
     * @param country object to be updated
     */
    void update(Country country); // U

    /**
     * removes a record from database connected to passed id
     *
     * @param id of object to be removed
     */
    void delete(int id); // D

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
