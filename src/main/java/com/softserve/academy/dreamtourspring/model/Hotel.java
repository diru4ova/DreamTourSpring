package com.softserve.academy.dreamtourspring.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idHotel;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "hotel_description")
    private String hotelDescription;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "stars")
    private int stars;

    @ManyToOne
    @JoinColumn(name = "id_city", referencedColumnName = "id")
    private City city;

    public Hotel() {
    }

    public Hotel(String hotelName, String hotelDescription, String imageUrl, int stars, City city) {
        this.hotelName = hotelName;
        this.hotelDescription = hotelDescription;
        this.imageUrl = imageUrl;
        this.stars = stars;
        this.city = city;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Hotel)) {
            return false;
        }
        Hotel hotel = (Hotel) o;
        return idHotel == hotel.idHotel
            && stars == hotel.stars
            && Objects.equals(hotelName, hotel.hotelName)
            && Objects.equals(hotelDescription, hotel.hotelDescription)
            && Objects.equals(imageUrl, hotel.imageUrl)
            && Objects.equals(city, hotel.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHotel, hotelName, hotelDescription, imageUrl, stars, city);
    }

    @Override
    public String toString() {
        return "Hotel{"
            + "idHotel=" + idHotel
            + ", hotelName='" + hotelName + '\''
            + ", hotelDescription='" + hotelDescription + '\''
            + ", imageUrl='" + imageUrl + '\''
            + ", stars=" + stars
            + ", city=" + city
            + '}';
    }

}
