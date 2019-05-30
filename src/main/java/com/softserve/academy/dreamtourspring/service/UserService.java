package com.softserve.academy.dreamtourspring.service;

import com.softserve.academy.dreamtourspring.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> list();
}