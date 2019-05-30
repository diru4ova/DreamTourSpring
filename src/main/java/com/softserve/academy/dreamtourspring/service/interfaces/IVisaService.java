package com.softserve.academy.dreamtourspring.service.interfaces;

import com.softserve.academy.dreamtour.entity.Visa;
import com.softserve.academy.dreamtourspring.model.Visa;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface IVisaService {

    List<Visa> getAll() throws SQLException, NamingException;

    boolean add(Visa visa) throws SQLException, NamingException; // C

    Visa get(int id) throws SQLException, NamingException; // R

    boolean update(Visa visa) throws SQLException, NamingException; // U

    boolean delete(int id) throws SQLException, NamingException; // D

    Visa hasVisa(int idPerson, int idCountry, LocalDate endDate)
        throws SQLException, NamingException;

    int getIdVisaByCountryByDate(int personId, int countryId, LocalDate endDate)
        throws SQLException, NamingException;

    List<Visa> getAllVisaByPerson(int idPerson) throws SQLException, NamingException;
}
