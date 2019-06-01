package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.City;

import java.util.List;

public interface ICityDao extends IDao<City> {

    List<City> getCityNameByCountry(String countryName);

    List<String> getAllCityNames();

    City getCityByName(String name);

}
