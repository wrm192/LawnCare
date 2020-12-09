package com.redflag.project.contact;

import com.redflag.project.booknow.BookNowController;
import com.redflag.project.booknow.BookNowRequest;
import com.redflag.project.booknow.BookNowService;
import com.redflag.project.contact.ContactController;
import com.redflag.project.contact.ContactRequest;
import com.redflag.project.contact.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class ContactControllerTests {
    @Mock
    ContactService service;

    ContactController controller;

    ContactRequest request;

    @BeforeEach
    void setup() {
        controller = new ContactController(service);
        request = new ContactRequest();
        request.setComment("this is a comment");
        request.setName("Name");
        request.setContactDetails("613-219-1111");
    }

    @Test
    void shouldCallCorrectService() throws Exception{

        controller.sendEmail(request);
        verify(service, times(1)).sendEmail(request);
    }
}
