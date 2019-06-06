package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.Booking;

import java.util.List;

/**
 * Booking service
 *
 * @author Danylo Lototskyi
 */
public interface IBookingService {

    /**
     * Find all instances of booking
     *
     * @return list of instances
     */
    List<Booking> getAll();

    /**
     * Makes given instance persistent.
     *
     * @param booking instance to be persisted
     */
    void add(Booking booking); // C

    /**
     * Find booking by id
     *
     * @param id booking id
     * @return found booking
     */
    Booking get(int id); // R

    /**
     * Update given booking
     *
     * @param booking instance to be updated
     */
    void update(Booking booking); // U

    /**
     * Delete booking by id
     *
     * @param id booking id
     */
    void delete(int id); // D

    /**
     * Find all bookings of particular person
     * @param idPerson person id for finding bookings
     * @return booking list of person
     */
    List<Booking> getAllByPerson(int idPerson);

}
