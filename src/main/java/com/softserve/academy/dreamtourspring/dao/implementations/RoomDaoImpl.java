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

@Repository
public class RoomDaoImpl implements IRoomDao {

    @Autowired
    private SessionFactory sessionFactory;

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

    @Override
    public List<Room> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Room").list();
    }

    @Override
    public void add(Room room) {
        sessionFactory.getCurrentSession().persist(room);
    }

    @Override
    public Room get(int id) {
        return sessionFactory.getCurrentSession().get(Room.class, id);
    }

    @Override
    public void update(Room room) {
        sessionFactory.getCurrentSession().update(room);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(id);
    }
}
