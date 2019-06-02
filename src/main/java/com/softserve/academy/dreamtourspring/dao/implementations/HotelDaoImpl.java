package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IHotelDao;
import com.softserve.academy.dreamtourspring.model.Hotel;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelDaoImpl implements IHotelDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Hotel> getAllHotelsByCityName(String cityName) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hotel where city ="
            + " (from City where cityName = :cityName)");

        query.setParameter("cityName", cityName);

        List<Hotel> hotelList = query.list();
        return hotelList;
    }

    @Override
    public int countTourist(String hotelName) {
        Query query = sessionFactory.getCurrentSession().createQuery("select count(idBooking)"
            + " from Booking where Hotel.idHotel"
            + "=(select idHotel from Hotel where hotelName=:hotelName)");

        query.setParameter("hotelName", hotelName);

        return (Integer) query.getSingleResult();
    }

    @Override
    public int averageStay(String hotelName) {
//        Query query = sessionFactory.getCurrentSession().createQuery("select avg(endDate-startDate)" +
//            "from Booking where Hotel.idHotel=(select idHotel from Hotel where hotelName=:hotelName)");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(
            "select avg(endDate - startDate) from booking where booking.id_hotel"
                + " = (select hotel.id from hotel where hotel_name = :hotelName)");

        query.setParameter("hotelName", hotelName);

        return (Integer)query.getSingleResult();
    }

    @Override
    public List<Hotel> getAllAvailableHotelsInCity(String startDate, String endDate, String cityName) {
        return null;
    }

    @Override
    public List<Hotel> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Hotel").list();
    }

    @Override
    public void add(Hotel hotel) {
        sessionFactory.getCurrentSession().persist(hotel);
    }

    @Override
    public Hotel get(int id) {

        return sessionFactory.getCurrentSession().get(Hotel.class, id);
    }

    @Override
    public void update(Hotel hotel) {

        sessionFactory.getCurrentSession().update(hotel);
    }

    @Override
    public void delete(int id) {

        sessionFactory.getCurrentSession().delete(id);
    }
}
