package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.Visa;

import java.time.LocalDate;
import java.util.List;

public interface IVisaDao extends IDao<Visa> {

    int getVisaCountByCountryForPerson(String countryName, int idPerson);

    List<Visa> getAllVisaByPerson(int idPerson);

    int getIdVisaByCountryByDate(int personId, int countryId, LocalDate endDate);

}
