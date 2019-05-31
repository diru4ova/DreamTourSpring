package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.Booking;

import java.util.List;

public interface IBookingService {

    List<Booking> getAll();

    void add(Booking booking); // C

    Booking get(int id); // R

    void update(Booking booking); // U

    void delete(int id); // D

    List<Booking> getAllByPerson(int idPerson);

}
