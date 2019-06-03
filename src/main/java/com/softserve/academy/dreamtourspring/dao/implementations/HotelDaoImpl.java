package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IHotelDao;
import com.softserve.academy.dreamtourspring.model.Booking;
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
        Query query = sessionFactory.getCurrentSession().createQuery("select count(b.idBooking)"
                + " from Booking b where b.hotel.idHotel"
                + "=(select h.idHotel from Hotel h where h.hotelName=:hotelName)");

        query.setParameter("hotelName", hotelName);
        List<Long> list = query.getResultList();
        if (list == null || list.isEmpty()) {
            return 0;
        }

        return list.get(0).intValue();
    }

    @Override
    public List<Booking> averageStay(String hotelName) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from Booking b where b.hotel.idHotel"
                        + " = (select h.idHotel from Hotel h where h.hotelName = :hotelName)");
        query.setParameter("hotelName", hotelName);
        List<Booking> bookingList = query.getResultList();
        return bookingList;
    }

    @Override
    public List<Hotel> getAllAvailableHotelsInCity(String startDate, String endDate, String cityName) {
        Query query = sessionFactory.getCurrentSession().createQuery("select distinct h"
                    + "  from Hotel h inner join City c"
                    + " on h.idHotel in(select Room.hotel.idHotel from Room where Room.idRoom not in"
                    + " (select Booking.room.idRoom from Booking"
                    + " where not(Booking.startDate>:endDate or Booking.endDate<:startDate)))"
                    + " and City.cityName=:cityName");


        /*if (endDate.equals("")) {
            endDate = "date_add(\"" + startDate + "\", INTERVAL 7 DAY)";
        }*/

        query.setParameter("endDate", endDate);
        query.setParameter("startDate", startDate);
        query.setParameter("cityName", cityName);

            //return getAllHotelsByCityName(cityName);


        List<Hotel> hotelList = query.getResultList();

        if (hotelList == null || hotelList.isEmpty()) {
            return getAllHotelsByCityName(cityName);
        }

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
