package com.softserve.academy.dreamtourspring.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Entity class, representing country table in SQL table
 */
@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int countryId;

    @Column(name = "country_name")
    private String countryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<City> cityList;

    public Country() {
    }

    public Country(String countryName) {

        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, countryName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Country)) {
            return false;
        }

        Country country = (Country) obj;
        return countryId == country.countryId
                && Objects.equals(countryName, country.countryName);
    }

    @Override
    public String toString() {
        return "Country [ country id: " + countryId + ", country name: " + countryName + "]";
    }

}
