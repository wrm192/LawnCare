package com.redflag.project.BookNowTests;

import com.redflag.project.booknow.BookNowRequest;
import com.redflag.project.booknow.BookNowService;
import com.redflag.project.service.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class BookNowServiceTests {
    BookNowService service;
    @Mock
    EmailService emailService;

    BookNowRequest request;
    @BeforeEach
    void setup() {
        service = new BookNowService(emailService);
        request.setAddress("Address");
        request.setName("Name");
        request.setPhoneNumber("613-219-1111");
    }

    @Test
    void shouldCallCorrectService() {
        service.sendEmail(request);
        verify(service, times(1)).sendEmail(request);
    }

}
