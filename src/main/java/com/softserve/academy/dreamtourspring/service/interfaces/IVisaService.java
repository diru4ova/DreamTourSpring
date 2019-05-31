package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtourspring.model.Visa;

import java.time.LocalDate;
import java.util.List;

public interface IVisaService {

    List<Visa> getAll();

    void add(Visa visa); // C

    Visa get(int id); // R

    void update(Visa visa); // U

    void delete(int id); // D

    Visa hasVisa(int idPerson, int idCountry, LocalDate endDate);

    int getIdVisaByCountryByDate(int personId, int countryId, LocalDate endDate);

    List<Visa> getAllVisaByPerson(int idPerson);
}
