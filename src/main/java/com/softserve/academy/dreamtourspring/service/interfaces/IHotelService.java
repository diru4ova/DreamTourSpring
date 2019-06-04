package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.Booking;
import com.softserve.academy.dreamtourspring.model.Hotel;

import java.util.List;

public interface IHotelService {

    List<Hotel> getAll();

    void add(Hotel hotel); // C

    Hotel get(int id); // R

    void update(Hotel hotel); // U

    void delete(int id); // D

    List<Hotel> getAllHotelsByCityName(String cityName);

    int countTourist(String hotelName);

    int averageStay(String hotelName);

    List<Hotel> getAllAvailableHotelsInCity(String startDate, String endDate, String cityName);

}
