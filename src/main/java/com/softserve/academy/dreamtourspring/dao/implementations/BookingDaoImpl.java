package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IBookingDao;
import com.softserve.academy.dreamtourspring.model.Booking;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingDaoImpl implements IBookingDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Booking> getAllByPerson(int idPerson) {
        return null;
    }

    @Override
    public List<Booking> getAll() {

        return sessionFactory.getCurrentSession().createQuery("from Booking").list();
    }

    @Override
    public void add(Booking booking) {

        sessionFactory.getCurrentSession().persist(booking);
    }

    @Override
    public Booking get(int id) {
        
        return sessionFactory.getCurrentSession().get(Booking.class, id);
    }

    @Override
    public void update(Booking booking) {

        sessionFactory.getCurrentSession().update(booking);
    }

    @Override
    public void delete(int id) {

        sessionFactory.getCurrentSession().delete(id);
    }
}
