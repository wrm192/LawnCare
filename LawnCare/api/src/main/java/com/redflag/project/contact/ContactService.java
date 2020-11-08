package com.redflag.project.contact;

import com.redflag.project.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ContactService {

    @Autowired
    EmailService service;

    private final String CONTACT_US_SUBJECT = "Contact Request";

    public ContactService(EmailService service) {
        this.service = service;
    }

    public void sendEmail(ContactRequest request) {
        System.out.println(request);
        this.service.sendSimpleMessage(CONTACT_US_SUBJECT, this.buildRequest(request));
    }

    private String buildRequest(ContactRequest request) {
        StringBuilder sb = new StringBuilder();
        sb.append(request.getName()).append(" is looking to contact you");
        sb.append("\n\n");
        sb.append("This is the contents of their message ").append(request.comment);
        sb.append("\n\n");
        sb.append("This is how they would like to be contacted: ").append(request.contactDetails);

        return sb.toString();
    }
}
