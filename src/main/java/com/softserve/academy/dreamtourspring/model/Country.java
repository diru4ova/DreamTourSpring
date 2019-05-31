package com.softserve.academy.dreamtourspring.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int countryId;

    @Column(name = "country_name")
    private String countryName;

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
