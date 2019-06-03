package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IHotelDao;
import com.softserve.academy.dreamtourspring.model.Booking;
import com.softserve.academy.dreamtourspring.model.Hotel;
import com.softserve.academy.dreamtourspring.service.interfaces.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    private IHotelDao hotelDao;

    @Override
    public List<Hotel> getAll() {
        return hotelDao.getAll();
    }

    @Override
    public void add(Hotel hotel) {
        hotelDao.add(hotel);
    }

    @Override
    public Hotel get(int id) {
        return hotelDao.get(id);
    }

    @Override
    public void update(Hotel hotel) {
        hotelDao.update(hotel);
    }

    @Override
    public void delete(int id) {
        hotelDao.delete(id);
    }

    @Override
    public List<Hotel> getAllHotelsByCityName(String cityName) {
        return hotelDao.getAllHotelsByCityName(cityName);
    }

    @Override
    public int countTourist(String hotelName) {
        return hotelDao.countTourist(hotelName);
    }

    @Override
    public int averageStay(String hotelName) {
        List<Booking> bookingList = hotelDao.averageStay(hotelName);
        int numberOfDays = 0;
        int numberOfBooks = bookingList.size();

        for (Booking booking : bookingList) {
            numberOfDays += DAYS.between(booking.getStartDate(), booking.getEndDate());
        }
        
        return numberOfDays/numberOfBooks;
    }

    @Override
    public List<Hotel> getAllAvailableHotelsInCity(String startDate, String endDate, String cityName) {
        return hotelDao.getAllAvailableHotelsInCity(startDate, endDate, cityName);
    }

}
