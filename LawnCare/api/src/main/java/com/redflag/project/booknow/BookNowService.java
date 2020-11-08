package com.redflag.project.booknow;

import com.redflag.project.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.redflag.project.common.constants.AppConstants.BOOK_NOW_SUBJECT;

@Service
public class BookNowService {
    @Autowired
    EmailService emailService;

    BookNowService(EmailService emailService){
        this.emailService = emailService;
    }

    public void sendEmail(BookNowRequest bookNowRequest) {
        System.out.println(bookNowRequest);
        this.emailService.sendSimpleMessage(BOOK_NOW_SUBJECT, this.buildRequest(bookNowRequest));
    }

    private String buildRequest(BookNowRequest bookNowRequest) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(bookNowRequest.getName()).append(" is looking to book now");
        stringBuilder.append("\n\n");
        stringBuilder.append("This is their address: ").append(bookNowRequest.getAddress());
        stringBuilder.append("\n\n");
        stringBuilder.append("Please contact them using this phone number: ").append(bookNowRequest.getPhoneNumber());

        return stringBuilder.toString();

    }
}
