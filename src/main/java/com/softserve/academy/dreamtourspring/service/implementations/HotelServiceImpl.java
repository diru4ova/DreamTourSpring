package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IHotelDao;
import com.softserve.academy.dreamtourspring.model.Hotel;
import com.softserve.academy.dreamtourspring.service.interfaces.IHotelService;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class HotelServiceImpl implements IHotelService {

    private IHotelDao hotelDao;

    @Override
    public List<Hotel> getAll() throws SQLException, NamingException {
        return hotelDao.getAll();
    }

    @Override
    public void add(Hotel hotel) throws SQLException, NamingException {
        hotelDao.add(hotel);
    }

    @Override
    public Hotel get(int id) throws SQLException, NamingException {
        return hotelDao.get(id);
    }

    @Override
    public void update(Hotel hotel) throws SQLException, NamingException {
        hotelDao.update(hotel);
    }

    @Override
    public void delete(int id) throws SQLException, NamingException {
        hotelDao.delete(id);
    }

    @Override
    public List<Hotel> getAllHotelsByCityName(String cityName) throws SQLException, NamingException {
        return hotelDao.getAllHotelsByCityName(cityName);
    }

    @Override
    public int countTourist(String hotelName) throws SQLException, NamingException {
        return hotelDao.countTourist(hotelName);
    }

    @Override
    public int averageStay(String hotelName) throws SQLException, NamingException {
        return hotelDao.averageStay(hotelName);
    }

    @Override
    public List<Hotel> getAllAvailableHotelsInCity(String startDate, String endDate, String cityName) throws SQLException, NamingException {
        return hotelDao.getAllAvailableHotelsInCity(startDate, endDate, cityName);
    }

}
