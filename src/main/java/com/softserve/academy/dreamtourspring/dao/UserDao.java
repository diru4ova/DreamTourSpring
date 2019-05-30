package com.softserve.academy.dreamtourspring.dao;

import com.softserve.academy.dreamtourspring.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    List<User> list();
}