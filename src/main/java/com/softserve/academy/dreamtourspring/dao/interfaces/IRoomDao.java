package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface IRoomDao extends IDao<Room> {

    List<Room> getFreeRoomsInHotel(LocalDate startDate, LocalDate endDate, int idHotel);

    List<Room> getAllRoomsInHotel (int idHotel);

}
