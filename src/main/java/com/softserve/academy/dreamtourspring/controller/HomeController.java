package com.softserve.academy.dreamtourspring.controller;

import com.softserve.academy.dreamtourspring.service.interfaces.ICityService;
import com.softserve.academy.dreamtourspring.service.interfaces.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ICountryService countryService;

    @Autowired
    private ICityService cityService;

    @GetMapping(value = "/")
    public String onHome(ModelMap map){

        map.addAttribute("countries", countryService.getAll());
        return "index";
    }

}
