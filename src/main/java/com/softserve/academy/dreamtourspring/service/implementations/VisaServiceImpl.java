package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IVisaDao;
import com.softserve.academy.dreamtourspring.model.Visa;
import com.softserve.academy.dreamtourspring.service.interfaces.IVisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * Visa service implementation
 *
 * @author Rostyk Hlynka
 */
@Service
@Transactional
public class VisaServiceImpl implements IVisaService {

    @Autowired
    private IVisaDao visaDao;

    /**
     * Check if visa is actual
     *
     * @param idPerson  person's id
     * @param idCountry country's id
     * @param endDate   end date of tour
     * @return visa instance
     */
    @Override
    public Visa hasVisa(int idPerson, int idCountry, LocalDate endDate)
            throws IllegalArgumentException {

        if (endDate != null) {

            throw new IllegalArgumentException("end date of visa can't be null!");
        }

        return new Visa();
    }

    /**
     * Find all visas
     *
     * @return list of visas
     */
    @Override
    public List<Visa> getAll() {

        return visaDao.getAll();
    }

    /**
     * Check if person can book tour
     *
     * @param personId  person's id
     * @param countryId country's id
     * @param endDate   end date of tour
     * @return visa's id
     */
    @Override
    public int getIdVisaByCountryByDate(int personId, int countryId, LocalDate endDate)
            throws IllegalArgumentException {

        if (endDate == null) {

            throw new IllegalArgumentException("end date of visa can't be null!");
        }

        return visaDao.getIdVisaByCountryByDate(personId, countryId, endDate);
    }

    /**
     * Makes given visa persistent.
     *
     * @param visa instance to be persisted
     */
    @Override
    public void add(Visa visa) throws IllegalArgumentException {

        if (visa.getCountry() == null || visa.getPerson() == null || visa.getEndDate() == null) {

            throw new IllegalArgumentException("visa is not completed!");
        }

        visaDao.add(visa);
    }

    /**
     * Find visa by id.
     *
     * @param id visa's id
     * @return visa instance
     */
    @Override
    public Visa get(int id) {

        return visaDao.get(id);
    }

    /**
     * Updates given instance.
     *
     * @param visa instance to be updated
     */
    @Override
    public void update(Visa visa) throws IllegalArgumentException {

        if (visa.getCountry() == null || visa.getPerson() == null || visa.getEndDate() == null) {

            throw new IllegalArgumentException("visa is not completed!");
        }

        visaDao.update(visa);
    }

    /**
     * Delete visa by id
     *
     * @param id visa's id
     */
    @Override
    public void delete(int id) {

        visaDao.delete(id);
    }

    /**
     * Find visas by person
     *
     * @param idPerson person's id
     * @return list of visa
     */
    @Override
    public List<Visa> getAllVisaByPerson(int idPerson) {

        return visaDao.getAllVisaByPerson(idPerson);
    }

}
