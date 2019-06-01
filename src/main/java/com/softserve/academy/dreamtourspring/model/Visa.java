package com.softserve.academy.dreamtourspring.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "visa")
public class Visa {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int idVisa;

    @Column(name="endDate")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "id_tourist", referencedColumnName = "id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "id_country", referencedColumnName = "id")
    private Country country;


    public Visa() { }

    public Visa(LocalDate endDate, Person person, Country country) {
        this.endDate = endDate;
        this.person = person;
        this.country = country;
    }

    public int getIdVisa() {
        return idVisa;
    }

    public void setIdVisa(int idVisa) {
        this.idVisa = idVisa;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) { 
            return true; 
        }
        
        if ((o instanceof Person) == false) {
            return false;
        }
   
        Visa visa = (Visa) o;

        return idVisa == visa.idVisa 
                && Objects.equals(person, visa.person)
                && Objects.equals(country, visa.country)
                && endDate.equals(visa.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVisa, person, country, endDate);
    }
    
    @Override
    public String toString() {
        return "Visa [" 
                + "idVisa=" + idVisa 
                + ", Person=" + person
                + ", Country=" + country
                + ", endDate=" + endDate
                + "]";
    }
    
}