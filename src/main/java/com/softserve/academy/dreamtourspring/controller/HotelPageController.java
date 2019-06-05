package com.softserve.academy.dreamtourspring.controller;

import com.softserve.academy.dreamtourspring.enums.RoomType;
import com.softserve.academy.dreamtourspring.model.City;
import com.softserve.academy.dreamtourspring.model.Room;
import com.softserve.academy.dreamtourspring.service.interfaces.ICityService;
import com.softserve.academy.dreamtourspring.service.interfaces.IHotelService;
import com.softserve.academy.dreamtourspring.service.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Hotel page controller class
 *
 * @author Danylo Lototskyi
 */
@Controller
public class HotelPageController {

    @Autowired
    private IHotelService hotelService;

    @Autowired
    private IRoomService roomService;

    @Autowired
    private ICityService cityService;

    /**
     * Handles get request from hotel list page with info about future booking
     *
     * @param chosenCity city name where particular hotel is
     * @param startDate start date of chosen period
     * @param endDate end date of chosen period
     * @param idHotel hotel id to show view
     * @param model model with info for showing it on view
     * @return hotel page view
     */
    @GetMapping("/hotel")
    public String hotelPage(@RequestParam String chosenCity, @RequestParam String startDate,
                            @RequestParam String endDate, @RequestParam String idHotel,
                            Model model) {
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

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(false); // true == allow create
        int currentUserId;

        if(session != null && session.getAttribute("userId") != null){
            System.out.println("session not null");
            currentUserId = (int) session.getAttribute("userId");
        } else {
            System.out.println("session null");
            currentUserId = -1;
        }

        model.addAttribute("countryId", city.getCountry().getCountryId());
        model.addAttribute("cityId", city.getCityId());
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("userId", currentUserId);

        return "hotelPage";
    }

}
