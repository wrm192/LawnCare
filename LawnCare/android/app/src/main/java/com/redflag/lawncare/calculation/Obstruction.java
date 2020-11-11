package com.redflag.lawncare.calculation;

public class Obstruction {
    private String personNo;

    private String personName;
    private String personUnit;
    private Double personNumb;
    public Obstruction(String personNo, String personName, String personUnit, double personNumb) {
        super();
        this.personNo = personNo;
        this.personName = personName;
        this.personUnit = personUnit;
        this.personNumb = personNumb;

    }
    public String getPersonName() {
        return personName;
    }
    public void setPersonName(String personName) {
        this.personName = personName;
    }
    public String getPersonAddress() {
        return personUnit;
    }
    public void setPersonAddress(String personAddress) {
        this.personUnit = personAddress;
    }

    public Double getPersonNumb() {
        return personNumb;
    }

    public void setPersonNumb(Double personNumb) {
        this.personNumb = personNumb;
    }

    public String getPersonNo() {
        return personNo;
    }

    public void setPersonNo(String personNo) {
        this.personNo = personNo;
    }
}
