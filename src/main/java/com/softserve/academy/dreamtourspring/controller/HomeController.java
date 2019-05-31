package com.softserve.academy.dreamtourspring.controller;

import com.softserve.academy.dreamtourspring.service.interfaces.ICityService;
import com.softserve.academy.dreamtourspring.service.interfaces.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class HomeController {

    @Autowired
    private ICountryService countryService;

    @Autowired
    private ICityService cityService;

    @GetMapping(value = "/")
    public String home(ModelMap map){
        map.addAttribute("countries", countryService.getAll());
        return "index";
    }

}
