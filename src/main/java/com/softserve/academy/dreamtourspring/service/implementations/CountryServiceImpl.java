package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.ICountryDao;
import com.softserve.academy.dreamtourspring.model.Country;
import com.softserve.academy.dreamtourspring.service.interfaces.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {

    @Autowired
    ICountryDao dao;

    @Override
    @Transactional (readOnly = true)
    public List<Country> getAll() throws SQLException, NamingException {
        return dao.getAll();
    }

    @Override
    @Transactional
    public void add(Country country) throws SQLException, NamingException {
        dao.add(country);
    }

    @Override
    @Transactional (readOnly = true)
    public Country get(int id) throws SQLException, NamingException {
        return dao.get(id);
    }

    @Override
    @Transactional
    public void update(Country country) throws SQLException, NamingException {
        dao.update(country);
    }

    @Override
    @Transactional
    public void delete(int id) throws SQLException, NamingException {
        dao.delete(id);
    }

    @Override
    @Transactional (readOnly = true)
    public List<String> getCountryNameByPerson(int personId) throws SQLException {
        return null;
    }

    @Override
    @Transactional (readOnly = true)
    public List<String> getAllNames() throws SQLException {
        return null;
    }
}
