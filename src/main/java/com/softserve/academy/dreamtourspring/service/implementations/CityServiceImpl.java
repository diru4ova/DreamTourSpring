package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.ICityDao;
import com.softserve.academy.dreamtourspring.model.City;
import com.softserve.academy.dreamtourspring.service.interfaces.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

    @Autowired
    ICityDao dao;

    @Override
    @Transactional (readOnly = true)
    public List<City> getAll() throws SQLException, NamingException {
        return dao.getAll();
    }

    @Override
    @Transactional
    public void add(City city) throws SQLException, NamingException {
        dao.add(city);
    }

    @Override
    @Transactional (readOnly = true)
    public City get(int id) throws SQLException, NamingException {
        return dao.get(id);
    }

    @Override
    @Transactional
    public void update(City city) throws SQLException, NamingException {
        dao.update(city);
    }

    @Override
    @Transactional
    public void delete(int id) throws SQLException, NamingException {
        dao.delete(id);
    }

    @Override
    @Transactional (readOnly = true)
    public List<String> getCityNameByCountry(String countryName) throws SQLException, NamingException {
        return null;
    }
}
