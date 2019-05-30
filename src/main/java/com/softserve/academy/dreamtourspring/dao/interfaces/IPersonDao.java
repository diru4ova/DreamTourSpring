package com.softserve.academy.dreamtourspring.dao.interfaces;

import com.softserve.academy.dreamtour.entity.Person;
import com.softserve.academy.dreamtourspring.model.Person;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface IPersonDao extends IDao<Person> {

    Person getPersonByCredentials(String username) throws SQLException, NamingException;
}
