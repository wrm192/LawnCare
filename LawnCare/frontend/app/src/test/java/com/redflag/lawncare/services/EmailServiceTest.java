package com.redflag.lawncare.services;

import com.redflag.lawncare.common.email.EmailService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class EmailServiceTest {

    @Test
    public void testSendEmail() {
        String subject = "Test from EmailServiceTest.java";
        String content = "This is a test work for EmailService.java. If the email is received, the test is successful.";

        assertTrue(EmailService.buildEmail(subject, content));
    }
}
