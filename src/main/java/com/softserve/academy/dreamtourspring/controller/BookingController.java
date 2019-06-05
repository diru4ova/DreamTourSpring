package com.softserve.academy.dreamtourspring.controller;

import com.softserve.academy.dreamtourspring.model.*;
import com.softserve.academy.dreamtourspring.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

/**
 * Booking controller class
 *
 * @author Danylo Lototskyi
 */
@Controller
public class BookingController {

    @Autowired
    private IVisaService visaService;

    @Autowired
    private IBookingService bookingService;

    @Autowired
    private ICountryService countryService;

    @Autowired
    private ICityService cityService;

    @Autowired
    private IPersonService personService;

    @Autowired
    private IHotelService hotelService;

    @Autowired
    private IRoomService roomService;

    /**
     * Handles post requests from hotel page with info of booking for person
     *
     * @param startDate start date of chosen period
     * @param endDate end date of chosen period
     * @param countryId country id where chosen city is
     * @param cityId city id where chosen hotel is
     * @param hotelId hotel id where chosen room is
     * @param roomId room id of chosen room
     * @return redirect to profile view
     */
    @PostMapping("/booking")
    public String personBook(@RequestParam String startDate, @RequestParam String endDate,
                             @RequestParam String countryId, @RequestParam String cityId,
                             @RequestParam String hotelId, @RequestParam String roomId) {

        System.out.println(startDate + " - " + endDate);
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(false);
        int personId = (Integer) session.getAttribute("userId");
        int countryIdInt = Integer.parseInt(countryId);
        LocalDate endLocalDate = LocalDate.parse(endDate);

        Visa visa = visaService.hasVisa(personId, countryIdInt, endLocalDate);
        if (visa.getId() == 0) {
            visa.setId(visaService.getIdVisaByCountryByDate(personId, countryIdInt, endLocalDate));
        }

        LocalDate startLocalDate = LocalDate.parse(startDate);
        Country country = countryService.get(countryIdInt);
        City city = cityService.get(Integer.parseInt(cityId));
        Person person = personService.get(personId);
        Hotel hotel = hotelService.get(Integer.parseInt(hotelId));
        Room room = roomService.get(Integer.parseInt(roomId));

        Booking booking = new Booking(startLocalDate, endLocalDate, country, city,
            person, hotel, visa, room);

        bookingService.add(booking);
        return "redirect:/profile";
    }
}