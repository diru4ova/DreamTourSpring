package com.softserve.academy.dreamtourspring.controller;

import com.softserve.academy.dreamtourspring.model.City;
import com.softserve.academy.dreamtourspring.model.Country;
import com.softserve.academy.dreamtourspring.service.interfaces.ICityService;
import com.softserve.academy.dreamtourspring.service.interfaces.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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

    /*@PostMapping(value = "/getCitiesNames")
    public ResponseEntity<String> getCities(ModelMap map, @RequestParam("country") String chosenCountryName){

        List<City> cityList = cityService.getCityNameByCountry(chosenCountryName);
        map.addAttribute("cities", );
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<String> entity = new ResponseEntity<String>("Группа " + group.getGroupStudentNumber() + " добавлена", headers, HttpStatus.OK);
        return entity;
        return "index";
    }*/
}
