package com.softserve.academy.dreamtourspring.controller;

import com.softserve.academy.dreamtourspring.model.Person;
import com.softserve.academy.dreamtourspring.service.interfaces.IPersonService;
import com.softserve.academy.dreamtourspring.utils.HashPasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    IPersonService personService;

    @GetMapping(value = "/login")
    public String onLogin() {
        return "login";
    }

    @PostMapping(value = "/login")
    public @ResponseBody
    ResponseEntity<Object> login(@RequestParam("username") String username,
                                 @RequestParam("password") String password) {

        Person person = personService.getPersonByCredentials(username);

        if (person != null) {

            boolean validPassword = HashPasswordUtil.checkPassword(password, person.getPassword());

            if (validPassword) {

                ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpSession session =  attr.getRequest().getSession(true); // true == allow create
                session.setAttribute("user", username);
                session.setAttribute("userId", person.getId());
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}