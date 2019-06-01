package com.softserve.academy.dreamtourspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {


    @GetMapping(value = "/profile")
    public String onProfile(){

        return "profile";
    }

}
