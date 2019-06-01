package com.softserve.academy.dreamtourspring.dao.interfaces;

import java.util.List;

public interface IDao<T> {

    List<T> getAll();

    void add(T t); // C

    T get(int id); // R

    void update(T t); // U

    void delete(int id); // D

}
