package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IBookingDao;
import com.softserve.academy.dreamtourspring.model.Booking;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class BookingDaoImpl implements IBookingDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Booking> getAllByPerson(int idPerson) throws SQLException, NamingException {
        return null;
    }

    @Override
    public List<Booking> getAll() throws SQLException, NamingException {

        return sessionFactory.getCurrentSession().createQuery("from Booking").list();
    }

    @Override
    public void add(Booking booking) throws SQLException, NamingException {

        sessionFactory.getCurrentSession().persist(booking);
    }

    @Override
    public Booking get(int id) throws SQLException, NamingException {
        
        return sessionFactory.getCurrentSession().get(Booking.class, id);
    }

    @Override
    public void update(Booking booking) throws SQLException, NamingException {

        sessionFactory.getCurrentSession().update(booking);
    }

    @Override
    public void delete(int id) throws SQLException, NamingException {

        sessionFactory.getCurrentSession().delete(id);
    }
}
