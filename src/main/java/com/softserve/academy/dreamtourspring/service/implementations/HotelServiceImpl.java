package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IHotelDao;
import com.softserve.academy.dreamtourspring.model.Booking;
import com.softserve.academy.dreamtourspring.model.Hotel;
import com.softserve.academy.dreamtourspring.service.interfaces.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@Transactional
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
    public int[] countTourist(List<Hotel> hotels) {
        int[] countTourist = new int[hotels.size()];
        for (Hotel hotel : hotels) {
            int i = 0;
            countTourist[i] = hotelDao.countTourist(hotel.getHotelName());
            ++i;
        }
        return countTourist;
    }

    @Override
    public int[] averageStay(List<Hotel> hotels) {
        int[] averageStay = new int[hotels.size()];
        for (Hotel hotel : hotels) {
            int i = 0;
            List<Booking> bookingList = hotelDao.averageStay(hotel.getHotelName());
            int numberOfDays = 0;
            int numberOfBooks = bookingList.size();

            for (Booking booking : bookingList) {
                numberOfDays += DAYS.between(booking.getStartDate(), booking.getEndDate());
            }

            if (numberOfBooks == 0) {
                averageStay[i] = 0;
            } else {
                averageStay[i] = numberOfDays / numberOfBooks;
            }

            ++i;
        }

        /*List<Booking> bookingList = hotelDao.averageStay(hotelName);
        int numberOfDays = 0;
        int numberOfBooks = bookingList.size();

        for (Booking booking : bookingList) {
            numberOfDays += DAYS.between(booking.getStartDate(), booking.getEndDate());
        }

        if(numberOfBooks == 0){
            return 0;
        }
        
        return numberOfDays/numberOfBooks;*/
        return averageStay;

    }

    @Override
    public List<Hotel> getAllAvailableHotelsInCity(String startDate, String endDate, String cityName) {

        LocalDate start;
        LocalDate end;

        //List<Hotel> hotels;

        if (startDate.equals("") && endDate.equals("")) {
            return hotelDao.getAllHotelsByCityName(cityName);
        }else if(!startDate.equals("") && endDate.equals("")){
            start = LocalDate.parse(startDate);
            end = start.plusDays(7);
            return hotelDao.getAllAvailableHotelsInCity(start, end, cityName);
        } else {
            start = LocalDate.parse(startDate);
            end = LocalDate.parse(endDate);
            return hotelDao.getAllAvailableHotelsInCity(start, end, cityName);
        }

        //return hotels;
    }

}
