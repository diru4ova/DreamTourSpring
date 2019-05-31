package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.ICountryDao;
import com.softserve.academy.dreamtourspring.model.Country;
import com.softserve.academy.dreamtourspring.service.interfaces.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {

    @Autowired
    ICountryDao dao;

    @Override
    @Transactional (readOnly = true)
    public List<Country> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public void add(Country country) {
        dao.add(country);
    }

    @Override
    @Transactional (readOnly = true)
    public Country get(int id) {
        return dao.get(id);
    }

    @Override
    @Transactional
    public void update(Country country) {
        dao.update(country);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    @Transactional (readOnly = true)
    public List<String> getCountryNameByPerson(int personId) {
        return null;
    }

    @Override
    @Transactional (readOnly = true)
    public List<String> getAllNames() {
        return null;
    }
}
