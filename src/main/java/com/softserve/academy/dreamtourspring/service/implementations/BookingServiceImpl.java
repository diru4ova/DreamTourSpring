package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IBookingDao;
import com.softserve.academy.dreamtourspring.model.Booking;
import com.softserve.academy.dreamtourspring.service.interfaces.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Booking service implementation
 *
 * @author Danylo Lototskyi
 */
@Service
@Transactional
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private IBookingDao bookingDao;

    /**
     * Find all instances of booking
     *
     * @return list of instances
     */
    @Override
    public List<Booking> getAll() {
        return bookingDao.getAll();
    }

    /**
     * Makes given instance persistent.
     *
     * @param booking instance to be persisted
     */
    @Override
    public void add(Booking booking) {

        if (booking.getCountry() == null || booking.getCity() == null || booking.getHotel() == null
            || booking.getPerson() == null || booking.getRoom() == null
            || booking.getVisa() == null || booking.getStartDate() == null
            || booking.getEndDate() == null) {

            throw new IllegalArgumentException("booking is not completed!");
        }

        bookingDao.add(booking);
    }

    /**
     * Find booking by id
     *
     * @param id booking id
     * @return found booking
     */
    @Override
    public Booking get(int id) {
        return bookingDao.get(id);
    }

    /**
     * Update given booking
     *
     * @param booking instance to be updated
     */
    @Override
    public void update(Booking booking) {

        if (booking.getCountry() == null || booking.getCity() == null || booking.getHotel() == null
            || booking.getPerson() == null || booking.getRoom() == null
            || booking.getVisa() == null || booking.getStartDate() == null
            || booking.getEndDate() == null) {

            throw new IllegalArgumentException("booking is not completed!");
        }

        bookingDao.update(booking);
    }

    /**
     * Delete booking by id
     *
     * @param id booking id
     */
    @Override
    public void delete(int id) {
        bookingDao.delete(id);
    }

    /**
     * Find all bookings of particular person
     *
     * @param idPerson person id for finding bookings
     * @return booking list of person
     */
    @Override
    public List<Booking> getAllByPerson(int idPerson) {
        return bookingDao.getAllByPerson(idPerson);
    }
}
