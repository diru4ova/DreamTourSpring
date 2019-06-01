package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.Country;

import java.util.List;

public interface ICountryService {

    List<Country> getAll();

    void add(Country country); // C

    Country get(int id); // R

    void update(Country country); // U

    void delete(int id); // D

    List<String> getCountryNameByPerson(int personId);

    List<String> getAllNames();

    Country getCountryByName(String countryName);

}
