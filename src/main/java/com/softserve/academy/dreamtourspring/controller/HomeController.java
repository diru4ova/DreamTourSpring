package com.softserve.academy.dreamtourspring.controller;

import com.softserve.academy.dreamtourspring.controller.interceptors.LoggerInterceptor;
import com.softserve.academy.dreamtourspring.model.City;
import com.softserve.academy.dreamtourspring.service.interfaces.ICityService;
import com.softserve.academy.dreamtourspring.service.interfaces.ICountryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Home controller class
 *
 * @author Rostyk Hlynka
 */
@Controller
public class HomeController {

    private static Logger logger = Logger.getLogger(LoggerInterceptor.class);

    @Autowired
    private ICountryService countryService;

    @Autowired
    private ICityService cityService;

    /**
     * Handles get request to welcome page
     *
     * @return welcome view
     */
    @GetMapping(value = "/")
    public String onHome(ModelMap map) {

        map.addAttribute("countries", countryService.getAll());
        return "index";
    }

    /**
     * Handles post request to welcome page (for login and registration)
     *
     * @return logical view name
     */
    @PostMapping(value = "/home")
    public String home() {

        return "redirect:/";
    }

    /**
     * Retrieve cities by country name
     *
     * @param chosenCountry name of country
     * @return cities' name as string
     */
    @PostMapping(value = "/getCities", produces = "text/plain")
    public @ResponseBody
    String getCities(@RequestParam("country") String chosenCountry) {

        List<String> cityNames = null;

        try {
            cityNames = cityService.getCityNameByCountry(chosenCountry);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
        }
        String citiesString = String.join(",", cityNames);

        return citiesString;
    }

}
