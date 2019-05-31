package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IVisaDao;
import com.softserve.academy.dreamtourspring.model.Visa;
import com.softserve.academy.dreamtourspring.service.interfaces.IVisaService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public class VisaServiceImpl implements IVisaService {

    @Autowired
    private IVisaDao visaDao;

    @Override
    public Visa hasVisa(int idPerson, int idCountry, LocalDate endDate) throws SQLException, NamingException {

        return new Visa();
    }

    @Override
    public List<Visa> getAll() throws SQLException, NamingException {

        return visaDao.getAll();
    }

    @Override
    public int getIdVisaByCountryByDate(int personId, int countryId, LocalDate endDate)
            throws SQLException, NamingException {

        return visaDao.getIdVisaByCountryByDate(personId, countryId, endDate);
    }

    @Override
    public void add(Visa visa) throws SQLException, NamingException {

        visaDao.add(visa);
    }

    @Override
    public Visa get(int id) throws SQLException, NamingException {

        return visaDao.get(id);
    }

    @Override
    public void update(Visa visa) throws SQLException, NamingException {

        visaDao.update(visa);
    }

    @Override
    public void delete(int id) throws SQLException, NamingException {

        visaDao.delete(id);
    }

    @Override
    public List<Visa> getAllVisaByPerson(int idPerson) throws SQLException, NamingException {

        return visaDao.getAllVisaByPerson(idPerson);
    }

}
