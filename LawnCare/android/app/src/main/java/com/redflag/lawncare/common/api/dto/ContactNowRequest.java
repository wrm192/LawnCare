package com.redflag.lawncare.common.api.dto;

import java.io.OutputStreamWriter;

public class ContactNowRequest implements  RequestSetter {
    String name;
    String contactDetails;
    String comment;

    public String getName() {
        return name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public String getComment() {
        return comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ContactNowRequest{" +
                "name='" + name + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public void setRequestParams(OutputStreamWriter writer) throws Exception {
        writer.write("{\n\t\"name\":\"" + this.name + "\",");
        writer.write("\n\t\"contactDetails\":\"" + this.contactDetails + "\",");
        writer.write("\n\t\"comment\":\"" + this.comment + "\"\n}");
    }
}
