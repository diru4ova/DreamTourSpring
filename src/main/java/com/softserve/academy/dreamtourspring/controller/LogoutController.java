package com.softserve.academy.dreamtourspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * Logout controller class
 *
 * @author Rostyk Hlynka
 */
@Controller
public class LogoutController {

    /**
     * Handles get request to log out
     *
     * @return welcome view
     */
    @GetMapping(value = "/logout")
    public String logout() {

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(false); // true == allow create
        session.invalidate();

        return "redirect:/";
    }
}
