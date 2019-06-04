package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.ICityDao;
import com.softserve.academy.dreamtourspring.model.City;
import com.softserve.academy.dreamtourspring.service.interfaces.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements ICityService {

    @Autowired
    ICityDao dao;

    @Override
    public List<City> getAll() {
        return dao.getAll();
    }

    @Override
    public void add(City city) {
        dao.add(city);
    }

    @Override
    public City get(int id) {
        return dao.get(id);
    }

    @Override
    public void update(City city) {
        dao.update(city);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public List<String> getCityNameByCountry(String countryName) {
        return dao.getCityNameByCountry(countryName);
    }

    @Override
    public List<String> getAllCityNames() {
        return dao.getAllCityNames();
    }

    @Override
    public City getCityByName(String cityName) {
        return dao.getCityByName(cityName);
    }
}
