package com.softserve.academy.dreamtourspring.dao.implementations;

import com.softserve.academy.dreamtourspring.dao.interfaces.IVisaDao;
import com.softserve.academy.dreamtourspring.model.Person;
import com.softserve.academy.dreamtourspring.model.Visa;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.NamingException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisaDaoImpl implements IVisaDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Visa> getAll() throws SQLException, NamingException {

        return sessionFactory.getCurrentSession().createQuery("from Visa").list();
    }

    @Override
    public int getVisaCountByCountryForPerson(String countryName, int idPerson) throws SQLException, NamingException { ;

        return 0;
    }

    public void add(Visa visa) throws SQLException, NamingException {

        sessionFactory.getCurrentSession().persist(visa);
    }

    public Visa get(int id) throws SQLException, NamingException {

        return sessionFactory.getCurrentSession().get(Visa.class, id);
    }

    public void update(Visa visa) throws SQLException, NamingException {

        sessionFactory.getCurrentSession().update(visa);
    }

    public void delete(int id) throws SQLException, NamingException {

        sessionFactory.getCurrentSession().remove(id);
    }

    @Override
    public List<Visa> getAllVisaByPerson(int idPerson) throws SQLException, NamingException {

       return new ArrayList<>();

    }

    @Override
    public int getIdVisaByCountryByDate(int personId, int countryId, LocalDate endDate)
            throws SQLException, NamingException {

        return 0;
    }
}
