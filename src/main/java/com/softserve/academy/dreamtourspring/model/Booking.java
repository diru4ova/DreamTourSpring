package com.softserve.academy.dreamtourspring.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idBooking;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "id_country", referencedColumnName = "id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "id_city", referencedColumnName = "id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "id_tourist", referencedColumnName = "id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "id_hotel", referencedColumnName = "id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "id_visa", referencedColumnName = "id")
    private Visa visa;

    @ManyToOne
    @JoinColumn(name = "id_room", referencedColumnName = "id")
    private Room room;

    public Booking() {
    }

    public Booking(LocalDate startDate, LocalDate endDate, Country country,
                   City city, Person person, Hotel hotel, Visa visa, Room room) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.country = country;
        this.city = city;
        this.person = person;
        this.hotel = hotel;
        this.visa = visa;
        this.room = room;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Visa getVisa() {
        return visa;
    }

    public void setVisa(Visa visa) {
        this.visa = visa;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;
        return idBooking == booking.idBooking
            && Objects.equals(startDate, booking.startDate)
            && Objects.equals(endDate, booking.endDate)
            && Objects.equals(country, booking.country)
            && Objects.equals(city, booking.city)
            && Objects.equals(person, booking.person)
            && Objects.equals(hotel, booking.hotel)
            && Objects.equals(visa, booking.visa)
            && Objects.equals(room, booking.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking, startDate, endDate, country, city, person, hotel, visa, room);
    }

    @Override
    public String toString() {
        return "Booking{"
            + "idBooking=" + idBooking
            + ", startDate=" + startDate
            + ", endDate=" + endDate
            + ", country=" + country
            + ", city=" + city
            + ", person=" + person
            + ", hotel=" + hotel
            + ", visa=" + visa
            + ", room=" + room
            + '}';
    }
}
