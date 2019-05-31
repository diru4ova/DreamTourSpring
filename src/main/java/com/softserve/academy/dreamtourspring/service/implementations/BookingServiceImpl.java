package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IBookingDao;
import com.softserve.academy.dreamtourspring.model.Booking;
import com.softserve.academy.dreamtourspring.service.interfaces.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Service
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private IBookingDao bookingDao;

    @Override
    public List<Booking> getAll() throws SQLException, NamingException {
        return bookingDao.getAll();
    }

    @Override
    public void add(Booking booking) throws SQLException, NamingException {
        bookingDao.add(booking);
    }

    @Override
    public Booking get(int id) throws SQLException, NamingException {
        return bookingDao.get(id);
    }

    @Override
    public void update(Booking booking) throws SQLException, NamingException {
        bookingDao.update(booking);
    }

    @Override
    public void delete(int id) throws SQLException, NamingException {
        bookingDao.delete(id);
    }

    @Override
    public List<Booking> getAllByPerson(int idPerson) throws SQLException, NamingException {
        return bookingDao.getAllByPerson(idPerson);
    }
}
