package com.softserve.academy.dreamtourspring.controller;

import com.softserve.academy.dreamtourspring.dao.interfaces.IVisaDao;
import com.softserve.academy.dreamtourspring.model.*;
import com.softserve.academy.dreamtourspring.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Objects;

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

    @PostMapping("/booking")
    public String personBook(@RequestParam(required=false,name="startDate") String startDate,
                             @RequestParam(required=false,name="endDate") String endDate,
                             @RequestParam(required=false,name="countryId") String countryId,
                             @RequestParam(required=false,name="cityId") String cityId,
                             @RequestParam(required=false,name="hotelId") String hotelId,
                             @RequestParam(required=false,name="roomId") String roomId,
                             Model model) {

        System.out.println("BOOKIING ADSADSA " + countryId);
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);
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