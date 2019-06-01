package com.softserve.academy.dreamtourspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping(value = "/login")
    public String onLogin(){

        return "login";
    }

    @GetMapping(value = "/logout")
    public String onLogout(){

        return "redirect:/";
    }

    @GetMapping(value = "/registration")
    public String onRegistration(){

        return "registration";
    }
}
