package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.ICountryDao;
import com.softserve.academy.dreamtourspring.model.Country;
import com.softserve.academy.dreamtourspring.service.interfaces.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements ICountryService {

    @Autowired
    ICountryDao dao;

    @Override
    public List<Country> getAll() {
        return dao.getAll();
    }

    @Override
    public void add(Country country) {
        dao.add(country);
    }

    @Override
    public Country get(int id) {
        return dao.get(id);
    }

    @Override
    public void update(Country country) {
        dao.update(country);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public List<String> getCountryNameByPerson(int personId) {
        return dao.getCountryNameByPerson(personId);
    }

    @Override
    public List<String> getAllNames() {
        return dao.getAllNames();
    }

    @Override
    public Country getCountryByName(String countryName) {
        return dao.getCountryByName(countryName);
    }
}
