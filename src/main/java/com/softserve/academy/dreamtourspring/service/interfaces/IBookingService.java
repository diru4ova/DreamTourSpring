package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.Booking;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface IBookingService {

    List<Booking> getAll() throws SQLException, NamingException;

    void add(Booking booking) throws SQLException, NamingException; // C

    Booking get(int id) throws SQLException, NamingException; // R

    void update(Booking booking) throws SQLException, NamingException; // U

    void delete(int id) throws SQLException, NamingException; // D

    List<Booking> getAllByPerson(int idPerson) throws SQLException, NamingException;

}
