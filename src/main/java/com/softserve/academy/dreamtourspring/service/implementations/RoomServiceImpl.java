package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IRoomDao;
import com.softserve.academy.dreamtourspring.model.Room;
import com.softserve.academy.dreamtourspring.service.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private IRoomDao roomDao;

    @Override
    public List<Room> getAll() {
        return roomDao.getAll();
    }

    @Override
    public void add(Room room) {
        roomDao.add(room);
    }

    @Override
    public Room get(int id) {
        return roomDao.get(id);
    }

    @Override
    public void update(Room room) {
        roomDao.update(room);
    }

    @Override
    public void delete(int id) {
        roomDao.delete(id);
    }

    @Override
    public List<Room> getFreeRoomsInHotel(String startDate, String endDate, int idHotel) {
        return roomDao.getFreeRoomsInHotel(startDate, endDate, idHotel);
    }
}
