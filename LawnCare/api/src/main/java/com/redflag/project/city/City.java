package com.redflag.project.city;

import com.redflag.project.common.BaseEntity;
import com.redflag.project.country.Country;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class City extends BaseEntity {

    @Column
    private String name;

    @Column
    private String cityCode;

    @ManyToOne
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", country=" + country +
                '}';
    }
}
