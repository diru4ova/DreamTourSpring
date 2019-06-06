package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.Visa;

import java.time.LocalDate;
import java.util.List;

/**
 * Visa service
 *
 * @author Rostyk Hlynka
 */
public interface IVisaService {

    /**
     * Find all visas
     *
     * @return list of visas
     */
    List<Visa> getAll();

    /**
     * Makes given visa persistent.
     *
     * @param visa instance to be persisted
     */
    void add(Visa visa); // C

    /**
     * Find visa by id.
     *
     * @param id visa's id
     * @return visa instance
     */
    Visa get(int id); // R

    /**
     * Updates given instance.
     *
     * @param visa instance to be updated
     */
    void update(Visa visa); // U

    /**
     * Delete visa by id
     *
     * @param id visa's id
     */
    void delete(int id); // D

    /**
     * Check if visa is actual
     *
     * @param idPerson  person's id
     * @param idCountry country's id
     * @param endDate   end date of tour
     * @return visa instance
     */
    Visa hasVisa(int idPerson, int idCountry, LocalDate endDate);

    /**
     * Check if person can book tour
     *
     * @param personId  person's id
     * @param countryId country's id
     * @param endDate   end date of tour
     * @return visa's id
     */
    int getIdVisaByCountryByDate(int personId, int countryId, LocalDate endDate);

    /**
     * Find visas by person
     *
     * @param idPerson person's id
     * @return list of visa
     */
    List<Visa> getAllVisaByPerson(int idPerson);
}
