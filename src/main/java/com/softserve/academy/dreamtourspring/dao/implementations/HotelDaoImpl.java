package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IHotelDao;
import com.softserve.academy.dreamtourspring.model.Booking;
import com.softserve.academy.dreamtourspring.model.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Hotel dao implementation
 *
 * @author Danylo Lototskyi
 */
@Repository
public class HotelDaoImpl implements IHotelDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Find all hotels in city
     * @param cityName city name for finding hotels
     * @return list of hotels in this city
     */
    @Override
    public List<Hotel> getAllHotelsByCityName(String cityName) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hotel where city ="
                + " (from City where cityName = :cityName)");

        query.setParameter("cityName", cityName);

        List<Hotel> hotelList = query.list();
        return hotelList;
    }

    /**
     * Count tourists in hotel for all time
     * @param hotelName hotel name for counting tourists
     * @return count of tourists in this hotel for all time
     */
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

    /**
     * Count average stay in hotel
     * @param hotelName hotel name for counting average stay here
     * @return number of average stay in this hotel
     */
    @Override
    public List<Booking> averageStay(String hotelName) {

        Query query = sessionFactory.getCurrentSession().createQuery(
                "from Booking b where b.hotel.idHotel"
                        + " = (select h.idHotel from Hotel h where h.hotelName = :hotelName)");

        query.setParameter("hotelName", hotelName);
        List<Booking> bookingList = query.getResultList();

        return bookingList;
    }

    /**
     * Find all available hotels in city on chosen period
     * @param startDate start date of period
     * @param endDate end date of period
     * @param cityName city name for finding available hotels
     * @return list of available hotels in this city
     */
    @Override
    public List<Hotel> getAllAvailableHotelsInCity(String startDate, String endDate, String cityName) {

        Session session = sessionFactory.getCurrentSession();
        List<Hotel> hotelList=null;
        Query query = null;

        if (endDate.equals("")) {
            query = session.createQuery("select distinct h"
                    + "  from Hotel h inner join City c"
                    + " on h.idHotel in(select r.hotel.idHotel from Room r where r.idRoom not in"
                    + " (select b.room.idRoom from Booking b"
                    + " where not(b.startDate>day(:startDate) or b.endDate<:startDate)))"
                    + " and h.city.cityName=:cityName");


            query.setParameter("startDate", LocalDate.parse(startDate));
            query.setParameter("cityName", cityName);
            hotelList = query.getResultList();

            return hotelList;
        }

        query = session.createQuery("select distinct h"
                + "  from Hotel h inner join City c"
                + " on h.idHotel in(select r.hotel.idHotel from Room r where r.idRoom not in"
                + " (select b.room.idRoom from Booking b"
                + " where not(b.startDate>:endDate or b.endDate<:startDate)))"
                + " and h.city.cityName=:cityName");

        query.setParameter("endDate", LocalDate.parse(endDate));
        query.setParameter("startDate", LocalDate.parse(startDate));
        query.setParameter("cityName", cityName);
        hotelList = query.getResultList();

        return hotelList;
    }

    /**
     * Find all instances of hotel
     *
     * @return list of instances
     */
    @Override
    public List<Hotel> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Hotel").list();
    }

    /**
     * Makes given instance persistent
     *
     * @param hotel instance to be persisted
     */
    @Override
    public void add(Hotel hotel) {
        sessionFactory.getCurrentSession().persist(hotel);
    }

    /**
     * Find hotel by id
     *
     * @param id hotel id
     * @return found hotel
     */
    @Override
    public Hotel get(int id) {

        return sessionFactory.getCurrentSession().get(Hotel.class, id);
    }

    /**
     * Update given hotel.
     *
     * @param hotel instance to be updated
     */
    @Override
    public void update(Hotel hotel) {

        sessionFactory.getCurrentSession().update(hotel);
    }

    /**
     * Delete hotel by id
     *
     * @param id hotel id
     */
    @Override
    public void delete(int id) {

        sessionFactory.getCurrentSession().delete(id);
    }
}
