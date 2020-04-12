package com.redflag.lawncare.services;

import com.redflag.lawncare.common.email.EmailBuilder;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class EmailBuilderTest {

    @Test
    public void testSendEmail() {
        String subject = "Test from EmailServiceTest.java";
        String content = "This is a test work for EmailService.java. If the email is received, the test is successful.";

        assertTrue(EmailBuilder.buildEmail(subject, content));
    }
}
