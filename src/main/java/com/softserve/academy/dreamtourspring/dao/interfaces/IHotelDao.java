package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.Hotel;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface IHotelDao extends IDao<Hotel>{

    List<Hotel> getAllHotelsByCityName(String cityName) throws SQLException, NamingException;

    int countTourist(String hotelName) throws SQLException, NamingException;

    int averageStay(String hotelName) throws SQLException, NamingException;

    List<Hotel> getAllAvailableHotelsInCity(String startDate, String endDate, int cityId)
        throws SQLException, NamingException;

}
