package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.Room;

import java.util.List;

public interface IRoomService {

    List<Room> getAll();

    void add(Room room); // C

    Room get(int id); // R

    void update(Room room); // U

    void delete(int id); // D

    List<Room> getFreeRoomsInHotel(String startDate, String endDate, int idHotel);

}
