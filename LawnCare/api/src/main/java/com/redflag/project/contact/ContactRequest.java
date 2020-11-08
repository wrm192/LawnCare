package com.redflag.project.contact;

public class ContactRequest {

    String name;
    String contactDetails;
    String comment;
    boolean wantsEmail; // if true, contact details should be an email or phone number if false
    // TODO validate that ^


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

    public boolean isWantsEmail() {
        return wantsEmail;
    }

    public void setWantsEmail(boolean wantsEmail) {
        this.wantsEmail = wantsEmail;
    }

    @Override
    public String toString() {
        return "ContactRequest{" +
                "name='" + name + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                ", comment='" + comment + '\'' +
                ", wantsEmail=" + wantsEmail +
                '}';
    }
}
