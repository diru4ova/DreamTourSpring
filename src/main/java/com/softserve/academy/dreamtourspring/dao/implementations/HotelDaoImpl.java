package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IHotelDao;
import com.softserve.academy.dreamtourspring.model.Hotel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class HotelDaoImpl implements IHotelDao {

    @Autowired
    private SessionFactory sessionFactory;

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

    @Override
    public List<Hotel> getAll() throws SQLException, NamingException {
        return sessionFactory.getCurrentSession().createQuery("from Hotel").list();
    }

    @Override
    public void add(Hotel hotel) throws SQLException, NamingException {
        sessionFactory.getCurrentSession().persist(hotel);
    }

    @Override
    public Hotel get(int id) throws SQLException, NamingException {

        return sessionFactory.getCurrentSession().get(Hotel.class, id);

    }

    @Override
    public void update(Hotel hotel) throws SQLException, NamingException {

        sessionFactory.getCurrentSession().update(hotel);
    }

    @Override
    public void delete(int id) throws SQLException, NamingException {

        sessionFactory.getCurrentSession().delete(id);
    }
}
