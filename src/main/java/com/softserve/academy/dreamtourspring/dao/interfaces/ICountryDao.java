package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtourspring.model.Country;

import java.sql.SQLException;
import java.util.List;

public interface ICountryDao extends IDao<Country> {

    List<String> getCountryNameByPerson(int personId) throws SQLException;


    List<String> getAllNames() throws SQLException;

}
