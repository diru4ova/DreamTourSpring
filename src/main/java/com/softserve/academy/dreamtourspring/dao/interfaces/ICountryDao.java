package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.Country;

import java.util.List;

public interface ICountryDao extends IDao<Country> {

    List<String> getCountryNameByPerson(int personId);

    List<String> getAllNames();

    Country getCountryByName (String countryName);

}
