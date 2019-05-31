package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IRoomDao;
import com.softserve.academy.dreamtourspring.model.Room;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class RoomDaoImpl implements IRoomDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Room> getFreeRoomsInHotel(String startDate, String endDate, int idHotel) throws SQLException, NamingException {
        return null;
    }

    @Override
    public List<Room> getAll() throws SQLException, NamingException {
        return sessionFactory.getCurrentSession().createQuery("from Room").list();
    }

    @Override
    public void add(Room room) throws SQLException, NamingException {
        sessionFactory.getCurrentSession().persist(room);
    }

    @Override
    public Room get(int id) throws SQLException, NamingException {
        return sessionFactory.getCurrentSession().get(Room.class, id);
    }

    @Override
    public void update(Room room) throws SQLException, NamingException {
        sessionFactory.getCurrentSession().update(room);
    }

    @Override
    public void delete(int id) throws SQLException, NamingException {
        sessionFactory.getCurrentSession().delete(id);
    }
}
