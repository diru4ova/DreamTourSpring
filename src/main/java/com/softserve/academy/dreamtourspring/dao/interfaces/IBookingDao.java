package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.Booking;

import java.util.List;

/**
 * Boooking dao
 *
 * @author Danylo Lototskyi
 */
public interface IBookingDao extends IDao<Booking> {

    /**
     * Find all bookings of particular person
     * @param idPerson person id for finding bookings
     * @return booking list of person
     */
    List<Booking> getAllByPerson(int idPerson);

}
