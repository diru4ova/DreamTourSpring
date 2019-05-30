package com.softserve.academy.dreamtourspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.softserve.academy.dreamtourspring.dao.UserDao;
import com.softserve.academy.dreamtourspring.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> list() {
        return userDao.list();
    }
}