package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IRoomDao;
import com.softserve.academy.dreamtourspring.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Room dao implementation
 *
 * @author Danylo Lototskyi
 */
@Repository
public class RoomDaoImpl implements IRoomDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Find all available rooms in hotel on chosen period
     * @param startDate start date of period
     * @param endDate end date of period
     * @param idHotel hotel id for finding free rooms
     * @return list of free rooms it this hotel
     */
    @Override
    public List<Room> getFreeRoomsInHotel(String startDate, String endDate, int idHotel) {

        List<Room> roomList;
        Session session = sessionFactory.getCurrentSession();
        Query query;

        if(startDate.equals("") && endDate.equals("")){
            query = session.createQuery("from Room r where r.hotel.idHotel=:idHotel");
            query.setParameter("idHotel", idHotel);
            roomList = query.list();
            return roomList;
        }

        if(!startDate.equals("") && endDate.equals("")){
            query = session.createQuery("from Room r where r.idRoom"
                    + " not in(select b.room.idRoom from Booking b where not"
                    + " (startDate>day(:startDate) or endDate<:startDate)) and r.hotel.idHotel=:idHotel");
            query.setParameter("startDate", LocalDate.parse(startDate));
            query.setParameter("idHotel", idHotel);
            roomList = query.list();
            return roomList;
        }

        query = session.createQuery("from Room r where r.idRoom"
            + " not in(select b.room.idRoom from Booking b where not"
            + " (startDate>:endDate or endDate<:startDate)) and r.hotel.idHotel=:idHotel");

        query.setParameter("startDate", LocalDate.parse(startDate));
        query.setParameter("endDate", LocalDate.parse(endDate));
        query.setParameter("idHotel", idHotel);

         roomList = query.list();



        return roomList;
    }

    /**
     * Find all instances of room
     *
     * @return list of instances
     */
    @Override
    public List<Room> getAll() {

        return sessionFactory.getCurrentSession().createQuery("from Room").list();
    }

    /**
     * Makes given instance persistent.
     *
     * @param room instance to be persisted
     */
    @Override
    public void add(Room room) {

        sessionFactory.getCurrentSession().persist(room);
    }

    /**
     * Find room by id
     *
     * @param id room id
     * @return found room
     */
    @Override
    public Room get(int id) {

        return sessionFactory.getCurrentSession().get(Room.class, id);
    }

    /**
     * Update given room
     *
     * @param room instance to be updated
     */
    @Override
    public void update(Room room) {

        sessionFactory.getCurrentSession().update(room);
    }

    /**
     * Delete room by id
     *
     * @param id room id
     */
    @Override
    public void delete(int id) {

        sessionFactory.getCurrentSession().delete(id);
    }
}
