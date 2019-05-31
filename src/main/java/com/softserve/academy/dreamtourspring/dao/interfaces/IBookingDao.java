package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.Booking;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface IBookingDao extends IDao<Booking> {

    List<Booking> getAllByPerson(int idPerson) throws SQLException, NamingException;

}
