package com.redflag.project.contact;

public class ContactRequest {

    String name;
    String contactDetails;
    String comment;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ContactRequest{" +
                "name='" + name + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
