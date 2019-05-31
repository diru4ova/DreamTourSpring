package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.Room;

import java.util.List;

public interface IRoomDao extends IDao<Room> {

    List<Room> getFreeRoomsInHotel(String startDate, String endDate, int idHotel);

}
