package com.softserve.academy.dreamtourspring.controller;

import com.softserve.academy.dreamtourspring.model.Hotel;
import com.softserve.academy.dreamtourspring.model.Room;
import com.softserve.academy.dreamtourspring.service.interfaces.IHotelService;
import com.softserve.academy.dreamtourspring.service.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.softserve.academy.dreamtourspring.enums.RoomType.STANDARD;

@Controller
public class HotelListController {

    @Autowired
    private IHotelService hotelService;
    @Autowired
    private IRoomService roomService;

    @GetMapping("/hotellist")
    public String hotelListPage(@RequestParam String chosenCity, @RequestParam String startDate,
                                @RequestParam String endDate, Model model){
        List<Hotel> hotels;
        int[] countTourist;
        int[] averageStay;

        if (startDate.equals("") && endDate.equals("")) {
            hotels = hotelService.getAllHotelsByCityName(chosenCity);

        } else {
            hotels = hotelService.getAllAvailableHotelsInCity(startDate, endDate, chosenCity);
        }
        countTourist = new int[hotels.size()];
        averageStay = new int[hotels.size()];

        for (Hotel hotel : hotels) {
            int i = 0;
            countTourist[i] = hotelService.countTourist(hotel.getHotelName());
            averageStay[i] = hotelService.averageStay(hotel.getHotelName());
            ++i;
        }


        List<Room> roomList = roomService.getAll();
        int price = 0;
        for (Room room : roomList) {
            if (room.getRoomType() == STANDARD) {
                price = room.getPrice();
            }
        }

        model.addAttribute("hotelList", hotels);
        model.addAttribute("countTourist", countTourist);
        model.addAttribute("averageStay", averageStay);
        model.addAttribute("price", price);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);

        return "hotellist";
    }


}
