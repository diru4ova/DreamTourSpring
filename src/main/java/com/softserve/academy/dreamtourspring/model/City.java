package com.softserve.academy.dreamtourspring.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int cityId;

    @Column(name="city_name")
    private String cityName;

    @ManyToOne
    @JoinColumn(name="id_country", referencedColumnName = "id")
    private Country country;

    public City() {
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, cityName, country);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof City)) {
            return false;
        }

        City city = (City) obj;
        return cityId == city.cityId
                && Objects.equals(cityName, city.cityName)
                && Objects.equals(country, city.country);

    }

    @Override
    public String toString() {
        return "City [ city id: " + cityId + ", city name: " + cityName + ", " + country + "]";
    }
}
