package com.redflag.project.country;


import com.redflag.project.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Country extends BaseEntity {

    @Column
    public String name;

    @Column
    public String countryCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
