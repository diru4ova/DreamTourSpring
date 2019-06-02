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
        Query query = sessionFactory.getCurrentSession().createQuery(
            "select avg(((year(endDate) * 365) + (month(endDate) * 12) + day(endDate)) "
                + "- ((year(startDate) * 365) + (month(startDate) * 12) + day(startDate)))"
                + " from Booking where Hotel.idHotel"
                + " = (select idHotel from Hotel where hotelName = :hotelName)");

        query.setParameter("hotelName", hotelName);

        return (Integer) query.getSingleResult();
    }

    @Override
    public List<Hotel> getAllAvailableHotelsInCity(String startDate, String endDate, String cityName) {
        Query query = sessionFactory.getCurrentSession().createQuery("select distinct"
            + " Hotel.idHotel, Hotel.hotelName, Hotel.hotelDescription, Hotel.imageUrl,"
            + " Hotel.stars, Hotel.city from Hotel join City"
            + " on Hotel.idHotel in(select Hotel.idHotel from Room where idRoom not in"
            + " (select Room.idRoom from Booking"
            + " where not(startDate>:endDate or endDate<:startDate)))"
            + " and City.cityName=:cityName");

        if (endDate.equals("")) {
            endDate = "date_add(\"" + startDate + "\", INTERVAL 7 DAY)";
        }

        query.setParameter("endDate", endDate);
        query.setParameter("startDate", startDate);
        query.setParameter("cityName", cityName);

        List<Hotel> hotelList = query.list();

        return hotelList;
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
