package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.Hotel;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface IHotelService {

    List<Hotel> getAll() throws SQLException, NamingException;

    void add(Hotel hotel) throws SQLException, NamingException; // C

    Hotel get(int id) throws SQLException, NamingException; // R

    void update(Hotel hotel) throws SQLException, NamingException; // U

    void delete(int id) throws SQLException, NamingException; // D

    List<Hotel> getAllHotelsByCityName(String cityName) throws SQLException, NamingException;

    int countTourist(String hotelName) throws SQLException, NamingException;

    int averageStay(String hotelName) throws SQLException, NamingException;

    List<Hotel> getAllAvailableHotelsInCity(String startDate, String endDate, String cityName)
        throws SQLException, NamingException;

}
