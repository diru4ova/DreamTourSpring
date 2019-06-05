package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.Room;

import java.util.List;

/**
 * Room service
 *
 * @author Danylo Lototskyi
 */
public interface IRoomService {

    /**
     * Find all instances of room
     *
     * @return list of instances
     */
    List<Room> getAll();

    /**
     * Makes given instance persistent.
     *
     * @param room instance to be persisted
     */
    void add(Room room); // C

    /**
     * Find room by id
     *
     * @param id room id
     * @return found room
     */
    Room get(int id); // R

    /**
     * Update given room
     *
     * @param room instance to be updated
     */
    void update(Room room); // U

    /**
     * Delete room by id
     *
     * @param id room id
     */
    void delete(int id); // D

    /**
     * Find all available rooms in hotel on chosen period
     * @param startDate start date of period
     * @param endDate end date of period
     * @param idHotel hotel id for finding free rooms
     * @return list of free rooms it this hotel
     */
    List<Room> getFreeRoomsInHotel(String startDate, String endDate, int idHotel);

}
