package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IBookingDao;
import com.softserve.academy.dreamtourspring.model.Booking;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Booking dao implementation
 *
 * @author Danylo Lototskyi
 */
@Repository
public class BookingDaoImpl implements IBookingDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Find all bookings of particular person
     * @param idPerson person id for finding bookings
     * @return booking list of person
     */
    @Override
    public List<Booking> getAllByPerson(int idPerson) {

        Query<Booking> query = sessionFactory.getCurrentSession()
                .createQuery("from Booking where person.id=:idPerson")
                .setParameter("idPerson", idPerson);

        List<Booking> bookingList = query.list();

        return bookingList;
    }

    /**
     * Find all instances of booking
     *
     * @return list of instances
     */
    @Override
    public List<Booking> getAll() {

        return sessionFactory.getCurrentSession().createQuery("from Booking").list();
    }

    /**
     * Makes given instance persistent.
     *
     * @param booking instance to be persisted
     */
    @Override
    public void add(Booking booking) {

        sessionFactory.getCurrentSession().persist(booking);
    }

    /**
     * Find booking by id
     *
     * @param id booking id
     * @return found booking
     */
    @Override
    public Booking get(int id) {
        
        return sessionFactory.getCurrentSession().get(Booking.class, id);
    }

    /**
     * Update given booking
     *
     * @param booking instance to be updated
     */
    @Override
    public void update(Booking booking) {

        sessionFactory.getCurrentSession().update(booking);
    }

    /**
     * Delete booking by id
     *
     * @param id booking id
     */
    @Override
    public void delete(int id) {

        sessionFactory.getCurrentSession().delete(id);
    }
}
