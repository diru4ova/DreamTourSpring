package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IRoomDao;
import com.softserve.academy.dreamtourspring.model.Room;
import com.softserve.academy.dreamtourspring.service.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class RoomServiceImpl implements IRoomService {

    @Autowired
    private IRoomDao roomDao;

    @Override
    public List<Room> getAll() throws SQLException, NamingException {
        return roomDao.getAll();
    }

    @Override
    public void add(Room room) throws SQLException, NamingException {
        roomDao.add(room);
    }

    @Override
    public Room get(int id) throws SQLException, NamingException {
        return roomDao.get(id);
    }

    @Override
    public void update(Room room) throws SQLException, NamingException {
        roomDao.update(room);
    }

    @Override
    public void delete(int id) throws SQLException, NamingException {
        roomDao.delete(id);
    }

    @Override
    public List<Room> getFreeRoomsInHotel(String startDate, String endDate, int idHotel) throws SQLException, NamingException {
        return roomDao.getFreeRoomsInHotel(startDate, endDate, idHotel);
    }
}
