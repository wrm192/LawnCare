package com.redflag.project.common.city;

import com.redflag.project.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class City extends BaseEntity {

    @Column
    private String name;

    @Column
    private String cityCode;

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


    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", cityCode='" + cityCode + '\'' +
                '}';
    }
}
