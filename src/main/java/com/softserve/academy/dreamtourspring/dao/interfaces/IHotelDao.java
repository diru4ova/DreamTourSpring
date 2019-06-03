package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.Booking;
import com.softserve.academy.dreamtourspring.model.Hotel;

import java.util.List;

public interface IHotelDao extends IDao<Hotel>{

    List<Hotel> getAllHotelsByCityName(String cityName);

    int countTourist(String hotelName);

    List<Booking> averageStay(String hotelName);

    List<Hotel> getAllAvailableHotelsInCity(String startDate, String endDate, String cityName);

}
