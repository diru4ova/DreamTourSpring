package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.model.Hotel;
import com.softserve.academy.dreamtourspring.service.interfaces.IHotelService;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class HotelServiceImpl implements IHotelService {

    private IHotelDao hotelDao;

    @Override
    public List<Hotel> getAll() throws SQLException, NamingException {
        return null;
    }

    @Override
    public boolean add(Hotel hotel) throws SQLException, NamingException {
        return false;
    }

    @Override
    public Hotel get(int id) throws SQLException, NamingException {
        return null;
    }

    @Override
    public boolean update(Hotel hotel) throws SQLException, NamingException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {
        return false;
    }

    @Override
    public List<Hotel> getAllHotelsByCityName(String cityName) throws SQLException, NamingException {
        return null;
    }

    @Override
    public int countTourist(String hotelName) throws SQLException, NamingException {
        return 0;
    }

    @Override
    public int averageStay(String hotelName) throws SQLException, NamingException {
        return 0;
    }

    @Override
    public List<Hotel> getAllAvailableHotelsInCity(String startDate, String endDate, String cityName) throws SQLException, NamingException {
        return null;
    }
}
