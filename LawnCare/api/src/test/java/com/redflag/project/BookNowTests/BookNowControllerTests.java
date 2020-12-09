package com.redflag.project.BookNowTests;


import com.redflag.project.booknow.BookNowController;
import com.redflag.project.booknow.BookNowRequest;
import com.redflag.project.booknow.BookNowService;
import com.redflag.project.calculation.CalculationController;
import com.redflag.project.calculation.CalculationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class BookNowControllerTests {

    @Mock
    BookNowService service;

    BookNowController controller;

    BookNowRequest request;

    @BeforeEach
    void setup() {
        controller = new BookNowController(service);
        request = new BookNowRequest();
        request.setAddress("Address");
        request.setName("Name");
        request.setPhoneNumber("613-219-1111");
    }

    @Test
    void shouldCallCorrectService() throws Exception{

        controller.sendEmail(request);
        verify(service, times(1)).sendEmail(request);
    }
}
