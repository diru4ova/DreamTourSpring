package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.Room;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface IRoomDao extends IDao<Room> {

    List<Room> getFreeRoomsInHotel(String startDate, String endDate, int idHotel)
        throws SQLException, NamingException;

}
