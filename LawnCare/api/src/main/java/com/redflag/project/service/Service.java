package com.redflag.project.service;

import com.redflag.project.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;


// Not sure the fields needed for this? Probably
@Entity
public class Service extends BaseEntity {

    @Column
    String name;

    @Column
    Double price;

    @Column
    Boolean isResidential;

    @Column
    Boolean isCommercial;

}
