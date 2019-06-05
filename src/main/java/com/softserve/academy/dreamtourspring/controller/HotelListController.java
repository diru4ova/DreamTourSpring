package com.softserve.academy.dreamtourspring.controller;

import com.softserve.academy.dreamtourspring.controller.interceptors.LoggerInterceptor;
import com.softserve.academy.dreamtourspring.model.Hotel;
import com.softserve.academy.dreamtourspring.service.interfaces.IHotelService;
import com.softserve.academy.dreamtourspring.service.interfaces.IRoomService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Controller class for operations with list of hotels
 */
@Controller
public class HotelListController {

    @Autowired
    private IHotelService hotelService;
    @Autowired
    private IRoomService roomService;
    

    /**
     * Method that handles /hotellist url request.
     *
     * @param chosenCountry country name passed from main page
     * @param chosenCity    city name passed from main page
     * @param startDate     booking start date passed from main page
     * @param endDate       booking end date passed from main paige
     * @param model         Model object
     * @return hotellist.jsp view
     */
    @PostMapping("/hotellist")
    public String hotelListPage(@RequestParam String chosenCountry, @RequestParam String chosenCity, @RequestParam String startDate,
                                @RequestParam String endDate, Model model) {

        List<Hotel> hotels = hotelService.getAllAvailableHotelsInCity(startDate, endDate, chosenCity);

        int[] countTourist = hotelService.countTourist(hotels);
        int[] averageStay = hotelService.averageStay(hotels);
        int price = roomService.standartPrice();

        model.addAttribute("hotelList", hotels);
        model.addAttribute("countTourist", countTourist);
        model.addAttribute("averageStay", averageStay);
        model.addAttribute("price", price);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("chosenCountry", chosenCountry);
        model.addAttribute("chosenCity", chosenCity);

        return "hotellist";
    }
}
