package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.Room;

import java.util.List;

/**
 * Room dao
 *
 * @author Danylo Lototskyi
 */
public interface IRoomDao extends IDao<Room> {

    /**
     * Find all available rooms in hotel on chosen period
     * @param startDate start date of period
     * @param endDate end date of period
     * @param idHotel hotel id for finding free rooms
     * @return list of free rooms it this hotel
     */
    List<Room> getFreeRoomsInHotel(String startDate, String endDate, int idHotel);

}
