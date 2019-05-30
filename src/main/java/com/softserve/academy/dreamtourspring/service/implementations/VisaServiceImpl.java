package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtour.dao.implementations.VisaDaoImpl;
import com.softserve.academy.dreamtour.dao.interfaces.IVisaDao;
import com.softserve.academy.dreamtour.entity.Visa;
import com.softserve.academy.dreamtour.service.interfaces.IVisaService;
import com.softserve.academy.dreamtourspring.dao.implementations.VisaDaoImpl;
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
        List<Visa> visaList = getAllVisaByPerson(idPerson);
        for (Visa visa : visaList) {
            if (visa.getIdCountry() == idCountry && visa.getIdPerson() == idPerson
                    && visa.getEndDate().isAfter(endDate)) {
                return visa;
            }
        }
        Visa visa = new Visa(idPerson, idCountry, endDate);
        add(visa);
        return visa;
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
    public boolean add(Visa visa) throws SQLException, NamingException {

        return visaDao.add(visa);
    }

    @Override
    public Visa get(int id) throws SQLException, NamingException {

        return visaDao.get(id);
    }

    @Override
    public boolean update(Visa visa) throws SQLException, NamingException {

        return visaDao.update(visa);
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {

        return visaDao.delete(id);
    }

    @Override
    public List<Visa> getAllVisaByPerson(int idPerson) throws SQLException, NamingException {

        return visaDao.getAllVisaByPerson(idPerson);
    }

}
