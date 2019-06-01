package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.City;

import java.util.List;

public interface ICityService {

    List<City> getAll();

    void add(City city); // C

    City get(int id); // R

    void update(City city); // U

    void delete(int id); // D

    List<String> getCityNameByCountry(String countryName);

    List<String> getAllCityNames();

    City getCityByName(String cityName);

}
