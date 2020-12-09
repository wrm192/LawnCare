package com.redflag.project.email;

import com.redflag.project.service.EmailService;
import com.redflag.project.service.EmailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailServiceTests {

    EmailService emailService;

    @Mock
    JavaMailSender mailSender;

    @BeforeEach
    void setup() {
        emailService = new EmailServiceImpl(mailSender);
    }

    @Test
    void shouldCallCorrectService() {

    }
}
