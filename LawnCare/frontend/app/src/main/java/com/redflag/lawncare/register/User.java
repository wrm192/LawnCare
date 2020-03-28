package com.redflag.lawncare.register;

import java.io.Serializable;

public class User implements Serializable {
    private String fName;
    private String lName;
    private String homePhoneNumb;
    private String workPhoneNumb;
    private String email;
    private String password;
    private String passwordConfirm;
    private String userType;
    private String address1;
    private String address2;
    private String postalCode;
    private String city;
    private String province;
    private String country;

    public User(String fName, String lName, String homePhoneNumb, String workPhoneNumb, String email, String password, String passwordConfirm, String userType, String address1, String address2, String postalCode, String city, String province, String country) {
        this.fName = fName;
        this.lName = lName;
        this.homePhoneNumb = homePhoneNumb;
        this.workPhoneNumb = workPhoneNumb;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.userType = userType;
        this.address1 = address1;
        this.address2 = address2;
        this.postalCode = postalCode;
        this.city = city;
        this.province = province;
        this.country = country;

    }

    public String toString() {
        return ("USER DATA:\n\nfname: " + fName + "\nlName: " + lName + "\nhomephone: " + homePhoneNumb
                + "\nworkphone: " + workPhoneNumb + "\nemail: " + email + "\npassword: " + password +
                "\npasswordconfirm: " + passwordConfirm + "\nusertype: " + userType + "\naddress1: " + address1
                + "\naddress2:" + address2 + "\npostalcode: " + postalCode + "\ncity: " + city + "\nprovince: " +
                province + "\ncountry: " + country);
    }
}
