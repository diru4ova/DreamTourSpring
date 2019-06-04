package com.softserve.academy.dreamtourspring.controller;

import com.softserve.academy.dreamtourspring.dao.interfaces.IVisaDao;
import com.softserve.academy.dreamtourspring.model.*;
import com.softserve.academy.dreamtourspring.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

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
    @GetMapping("/booking")
    public String personBook(@RequestParam String startDate, @RequestParam String endDate,
                             @RequestParam String countryId, @RequestParam String cityId,
                             @RequestParam String hotelId, @RequestParam HttpSession session,
                             @RequestParam String roomId, Model model) {
        int personId = (Integer) session.getAttribute("id");
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