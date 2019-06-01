package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IVisaDao;
import com.softserve.academy.dreamtourspring.model.Visa;
import com.softserve.academy.dreamtourspring.service.interfaces.IVisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VisaServiceImpl implements IVisaService {

    @Autowired
    private IVisaDao visaDao;

    @Override
    public Visa hasVisa(int idPerson, int idCountry, LocalDate endDate) {

        return new Visa();
    }

    @Override
    public List<Visa> getAll() {

        return visaDao.getAll();
    }

    @Override
    public int getIdVisaByCountryByDate(int personId, int countryId, LocalDate endDate) {

        return visaDao.getIdVisaByCountryByDate(personId, countryId, endDate);
    }

    @Override
    public void add(Visa visa) {

        visaDao.add(visa);
    }

    @Override
    public Visa get(int id) {

        return visaDao.get(id);
    }

    @Override
    public void update(Visa visa) {

        visaDao.update(visa);
    }

    @Override
    public void delete(int id) {

        visaDao.delete(id);
    }

    @Override
    public List<Visa> getAllVisaByPerson(int idPerson) {

        return visaDao.getAllVisaByPerson(idPerson);
    }

}
