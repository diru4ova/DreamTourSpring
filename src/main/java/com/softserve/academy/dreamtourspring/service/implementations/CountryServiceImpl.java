package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.ICountryDao;
import com.softserve.academy.dreamtourspring.model.Country;
import com.softserve.academy.dreamtourspring.service.interfaces.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation for performing business logic and access to DAO layer associated with Country object.
 *
 * @author Olena Andrushchenko
 */
@Service
@Transactional
public class CountryServiceImpl implements ICountryService {

    @Autowired
    ICountryDao dao;

    /**
     * @return list of countries.
     */
    @Override
    public List<Country> getAll() {
        return dao.getAll();
    }

    /**
     * adds a Country object to the table in database.
     *
     * @param country an object to be injected into database table.
     */
    @Override
    public void add(Country country) {
        dao.add(country);
    }

    /**
     * returns Country object by id.
     *
     * @param id of country to be retrieved.
     * @return Country object  from table in database.
     */
    @Override
    public Country get(int id) {
        return dao.get(id);
    }

    /**
     * updates a record in database connected to passed object
     *
     * @param country object to be updated
     */
    @Override
    public void update(Country country) {
        dao.update(country);
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
     * retrieves the list of countries that person has visited.
     *
     * @return list of all countries names that person has been to.
     */
    @Override
    public List<String> getCountryNameByPerson(int personId) throws IllegalArgumentException {
        return dao.getCountryNameByPerson(personId);
    }

    /**
     * retrieves the list of all countries names.
     *
     * @return list of all countries names that agency works with.
     */
    @Override
    public List<String> getAllNames()throws IllegalArgumentException {
        return dao.getAllNames();
    }

    /**
     * retrieves Country object from database connected to passed country name.
     *
     * @param countryName of country to be retrieved.
     * @return Country object from database connected to passed country name.
     */
    @Override
    public Country getCountryByName(String countryName)throws IllegalArgumentException {
        return dao.getCountryByName(countryName);
    }
}
