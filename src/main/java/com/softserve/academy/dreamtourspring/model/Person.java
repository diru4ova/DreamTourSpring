package com.softserve.academy.dreamtourspring.model;

import com.softserve.academy.dreamtourspring.enums.PersonType;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "pass")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "person_type")
    private PersonType personType;

    @OneToMany(mappedBy = "person")
    private List<Visa> visaList;

    public Person() {
    }

    public Person(int id, String username,
                  String password, String firstName,
                  String lastName, PersonType personType) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personType = personType;
    }

    public Person(String username, String password, String firstName,
                  String lastName, PersonType personType) {

        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personType = personType;
    }


    public int getId() {
        return id;
    }

    public void setIdPerson(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public List<Visa> getVisaList() {
        return visaList;
    }

    public void setVisaList(List<Visa> visaList) {
        this.visaList = visaList;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof Person)) {
            return false;
        }

        Person person = (Person) o;

        return id == person.id
                && username.equals(person.username)
                && password.equals(person.password)
                && firstName.equals(person.firstName)
                && lastName.equals(person.lastName)
                && personType == person.personType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, personType);
    }

    @Override
    public String toString() {

        return "Person ["
                + "id=" + id
                + ", username=" + username
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", personType=" + personType
                + "]";
    }

}