package com.redflag.project.membership;


import com.redflag.project.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

// this name is shit
@Entity
public class Membership extends BaseEntity {

    @Column
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
