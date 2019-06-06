package com.softserve.academy.dreamtourspring.controller;

import com.softserve.academy.dreamtourspring.model.Booking;
import com.softserve.academy.dreamtourspring.model.Country;
import com.softserve.academy.dreamtourspring.model.Person;
import com.softserve.academy.dreamtourspring.model.Visa;
import com.softserve.academy.dreamtourspring.service.interfaces.IBookingService;
import com.softserve.academy.dreamtourspring.service.interfaces.ICountryService;
import com.softserve.academy.dreamtourspring.service.interfaces.IPersonService;
import com.softserve.academy.dreamtourspring.service.interfaces.IVisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Profile controller class
 *
 * @author Rostyk Hlynka
 */
@Controller
public class ProfileController {

    @Autowired
    IPersonService personService;

    @Autowired
    IVisaService visaService;

    @Autowired
    IBookingService bookingService;

    @Autowired
    ICountryService countryService;

    /**
     * Handles get request and display profile page with person's data
     *
     * @return profile view
     */
    @GetMapping(value = "/profile")
    public String onProfile(ModelMap map) {

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(false); // true == allow create

        Integer userId = (Integer) session.getAttribute("userId");
        Person person = personService.get(userId);

        List<Visa> visaList = visaService.getAllVisaByPerson(userId);
        List<Country> countryList = new ArrayList<>();
        List<Booking> bookingList = bookingService.getAllByPerson(userId);

        for (Visa visa : visaList) {

            Country country = visa.getCountry();
            countryList.add(country);
        }

        map.addAttribute("person", person);
        map.addAttribute("countryList", countryList);
        map.addAttribute("visaList", visaList);
        map.addAttribute("bookingList", bookingList);

        return "profile";
    }

}
