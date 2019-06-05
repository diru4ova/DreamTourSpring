package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IRoomDao;
import com.softserve.academy.dreamtourspring.model.Room;
import com.softserve.academy.dreamtourspring.service.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Room service implementation
 *
 * @author Danylo Lototskyi
 */
@Service
@Transactional
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private IRoomDao roomDao;

    /**
     * Find all instances of room
     *
     * @return list of instances
     */
    @Override
    public List<Room> getAll() {
        return roomDao.getAll();
    }

    /**
     * Makes given instance persistent.
     *
     * @param room instance to be persisted
     */
    @Override
    public void add(Room room) {

        if (room.getHotel() == null) {

            throw new IllegalArgumentException("hotel can not be null!");
        }

        roomDao.add(room);
    }

    /**
     * Find room by id
     *
     * @param id room id
     * @return found room
     */
    @Override
    public Room get(int id) {
        return roomDao.get(id);
    }

    /**
     * Update given room
     *
     * @param room instance to be updated
     */
    @Override
    public void update(Room room) {

        if (room.getHotel() == null) {

            throw new IllegalArgumentException("room is not completed!");
        }

        roomDao.update(room);
    }

    /**
     * Delete room by id
     *
     * @param id room id
     */
    @Override
    public void delete(int id) {
        roomDao.delete(id);
    }

    /**
     * Find all available rooms in hotel on chosen period
     * @param startDate start date of period
     * @param endDate end date of period
     * @param idHotel hotel id for finding free rooms
     * @return list of free rooms it this hotel
     */
    @Override
    public List<Room> getFreeRoomsInHotel(String startDate, String endDate, int idHotel) {
        return roomDao.getFreeRoomsInHotel(startDate, endDate, idHotel);
    }
}
