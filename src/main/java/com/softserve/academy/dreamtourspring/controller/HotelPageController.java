package com.softserve.academy.dreamtourspring.controller;

import com.softserve.academy.dreamtourspring.enums.RoomType;
import com.softserve.academy.dreamtourspring.model.City;
import com.softserve.academy.dreamtourspring.model.Hotel;
import com.softserve.academy.dreamtourspring.model.Room;
import com.softserve.academy.dreamtourspring.service.interfaces.ICityService;
import com.softserve.academy.dreamtourspring.service.interfaces.IHotelService;
import com.softserve.academy.dreamtourspring.service.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HotelPageController {

    @Autowired
    private IHotelService hotelService;

    @Autowired
    private IRoomService roomService;

    @Autowired
    private ICityService cityService;

    @GetMapping("/hotel")
    public String hotelPage(@RequestParam String chosenCity, @RequestParam String chosenCountry,
                            @RequestParam String startDate, @RequestParam String endDate,
                            @RequestParam String idHotel, Model model) {
        int hotelId = Integer.parseInt(idHotel);

        List<Room> rooms = roomService.getFreeRoomsInHotel(startDate, endDate, hotelId);

        int countOfStandardRooms = 0;
        int countOfLuxeRooms = 0;
        for (Room room : rooms) {
            if (room.getRoomType() == RoomType.STANDARD) {
                countOfStandardRooms++;
                model.addAttribute("roomStandard", room);
            } else {
                countOfLuxeRooms++;
                model.addAttribute("roomLuxe", room);
            }
        }
        if (countOfStandardRooms == 0) {
            model.addAttribute("roomStandard", null);
        }
        if (countOfLuxeRooms == 0) {
            model.addAttribute("roomLuxe", null);
        }

        model.addAttribute("standardCount", countOfStandardRooms);
        model.addAttribute("luxeCount", countOfLuxeRooms);

        model.addAttribute("hotel", hotelService.get(hotelId));

        City city = cityService.getCityByName(chosenCity);

        model.addAttribute("countryId", city.getCountry().getCountryId());
        model.addAttribute("cityId", city.getCityId());
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);

        return "hotelPage";
    }

}
