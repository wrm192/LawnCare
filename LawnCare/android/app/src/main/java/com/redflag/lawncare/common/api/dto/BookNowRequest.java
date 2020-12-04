package com.redflag.lawncare.common.api.dto;

import java.io.OutputStreamWriter;
import java.net.URLConnection;

public class BookNowRequest implements RequestSetter {
    String name;
    String address;
    String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public void setRequestParams(OutputStreamWriter connection) throws Exception {
      /*  connection.write("{ \"name\":\"" + this.name + "\"");
        connection.write("\"address\":\"" + this.address + "\"");
        connection.write("\"phoneNumber\":\"" + this.phoneNumber + "\"}");*/

        connection.write("{\n\t\"name\":\"" + this.name + "\",");
        connection.write("\n\t\"address\":\"" + this.address + "\",");
        connection.write("\n\t\"phoneNumber\":\"" + this.phoneNumber + "\"\n}");
        //connection.write(this.toString());
    }
}
