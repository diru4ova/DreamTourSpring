package com.softserve.academy.dreamtourspring.service.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IRoomDao;
import com.softserve.academy.dreamtourspring.model.Room;
import com.softserve.academy.dreamtourspring.service.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static com.softserve.academy.dreamtourspring.enums.RoomType.STANDARD;

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

        LocalDate start;
        LocalDate end;

        if (startDate.equals("") && endDate.equals("")) {
            return roomDao.getAllRoomsInHotel(idHotel);

        } else if (!startDate.equals("") && endDate.equals("")) {
            start = LocalDate.parse(startDate);
            end = start.plusDays(7);
            return roomDao.getFreeRoomsInHotel(start, end, idHotel);

        } else {
            start = LocalDate.parse(startDate);
            end = LocalDate.parse(endDate);
            return roomDao.getFreeRoomsInHotel(start, end, idHotel);
        }

    }

    @Override
    public int standartPrice() {
        List<Room> roomList = roomDao.getAll();
        int price = 0;
        for (Room room : roomList) {
            if (room.getRoomType() == STANDARD) {
                price = room.getPrice();
            }
        }
        return price;
    }
}
