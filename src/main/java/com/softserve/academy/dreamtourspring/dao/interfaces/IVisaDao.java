package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.Visa;

import java.time.LocalDate;
import java.util.List;

/**
 * Visa dao
 *
 * @author Rostyk Hlynka
 */
public interface IVisaDao extends IDao<Visa> {


    int getVisaCountByCountryForPerson(String countryName, int idPerson);

    /**
     * Find visas by person
     * @param idPerson person's id
     * @return list of visa
     */
    List<Visa> getAllVisaByPerson(int idPerson);

    /**
     * Check if person can book tour
     * @param personId person's id
     * @param countryId country's id
     * @param endDate end date of tour
     * @return visa's id
     */
    int getIdVisaByCountryByDate(int personId, int countryId, LocalDate endDate);

}
