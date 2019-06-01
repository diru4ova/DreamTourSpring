package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IBookingDao;
import com.softserve.academy.dreamtourspring.model.Booking;
import com.softserve.academy.dreamtourspring.service.interfaces.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private IBookingDao bookingDao;

    @Override
    public List<Booking> getAll() {
        return bookingDao.getAll();
    }

    @Override
    public void add(Booking booking) {
        bookingDao.add(booking);
    }

    @Override
    public Booking get(int id) {
        return bookingDao.get(id);
    }

    @Override
    public void update(Booking booking) {
        bookingDao.update(booking);
    }

    @Override
    public void delete(int id) {
        bookingDao.delete(id);
    }

    @Override
    public List<Booking> getAllByPerson(int idPerson) {
        return bookingDao.getAllByPerson(idPerson);
    }
}
