package com.softserve.academy.dreamtourspring.controller;

import com.softserve.academy.dreamtourspring.service.interfaces.IBookingService;
import com.softserve.academy.dreamtourspring.service.interfaces.IPersonService;
import com.softserve.academy.dreamtourspring.service.interfaces.IVisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @Autowired
    IPersonService personService;

    @Autowired
    IVisaService visaService;

    @Autowired
    IBookingService bookingService;

    @GetMapping(value = "/profile")
    public String onProfile(ModelMap map){

        map.addAttribute("person", personService.getPersonByCredentials("Jarvizz"));
        map.addAttribute("visaList", visaService.getAllVisaByPerson(1));
        map.addAttribute("bookingList", bookingService.getAllByPerson(1));
        return "profile";
    }

}
