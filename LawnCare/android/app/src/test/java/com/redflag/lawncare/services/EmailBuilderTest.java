package com.redflag.lawncare.services;

import com.redflag.lawncare.common.email.EmailBuilder;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class EmailBuilderTest {

    private static final String SUBJECT = "Test from EmailServiceTest.java";
    private static final String CONTENT = "This is a test work for EmailService.java. If the email is received, the test is successful.";

    //@Test
    public void testSendEmail() {

        assertTrue(EmailBuilder.buildEmail(SUBJECT, CONTENT));
    }

    //@Test
    public void emailShouldFailOnNullInputs() {
        assertFalse(EmailBuilder.buildEmail(null,CONTENT));
        assertFalse(EmailBuilder.buildEmail(SUBJECT,null));
        assertFalse(EmailBuilder.buildEmail(null,null));
    }

}
