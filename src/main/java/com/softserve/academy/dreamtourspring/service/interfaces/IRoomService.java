package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.Room;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface IRoomService {

    List<Room> getAll() throws SQLException, NamingException;

    void add(Room room) throws SQLException, NamingException; // C

    Room get(int id) throws SQLException, NamingException; // R

    void update(Room room) throws SQLException, NamingException; // U

    void delete(int id) throws SQLException, NamingException; // D

    List<Room> getFreeRoomsInHotel(String startDate, String endDate, int idHotel)
        throws SQLException, NamingException;

}
