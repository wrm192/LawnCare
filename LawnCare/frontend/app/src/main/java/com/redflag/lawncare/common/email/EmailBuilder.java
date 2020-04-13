/**
 * EmailService class is a function to send:
 * 	1. an email only contains text
 * 	2. an email contains text and an attachment
 */

package com.redflag.lawncare.common.email;

import android.os.AsyncTask;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class EmailBuilder {

    private static final String protocol = "smtp";
    private static final String smtpHost = "smtp.gmail.com";
    private static final int port = 465;
    private static final String authorizeEnable =  "true";
    private static final String sslEnable = "true";
    private static final String mailDebug = "true";
    private static final String sendEmail = "testemailredflag@gmail.com";
    private static final String password = "redflag888";
    private static final String receiveEmail1 = "wrm192@gmail.com";

    /**
     * class must be used statically
     */
    private EmailBuilder() { }

    private static class EmailTask extends AsyncTask<Void, Void, Boolean> {

        String subject, content;

        EmailTask(String subject, String content) {
            this.subject = subject;
            this.content = content;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            return sendEmail(this.subject, this.content);
        }
    }

    private static boolean sendEmail(String subject, String content) {
        if(subject == null || content == null ) return false;

        try {
            Properties properties = new Properties();
            // Set transport protocol
            properties.put("mail.transport.protocol", protocol);
            // Set SMTP host server
            properties.put("mail.smtp.host", smtpHost);
            // Set port
            properties.put("mail.smtp.port", port);
            // Set authorize, default to true.
            properties.put("mail.smtp.auth", authorizeEnable);
            // Set whether using SSL security connection. Suggest true.
            properties.put("mail.smtp.ssl.enable", sslEnable);
            // Set display debug information on console.
            properties.put("mail.debug", mailDebug);
            Session session = Session.getInstance(properties);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sendEmail));
            // Multiple receive email addresses if necessary.
            // Suggest at least two. One for operation and one for backup.
            message.setRecipients(Message.RecipientType.TO, new InternetAddress[] {
                    new InternetAddress(receiveEmail1)
            });
            // Set message subject and content
            message.setSubject(subject);
            message.setText(content);
            // Create transport and send a text message
            Transport transport = session.getTransport();
            transport.connect(sendEmail, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Send a text email
     * @param subject
     * @param content
     * @return
     * @throws AddressException
     * @throws MessagingException
     */
    public static boolean buildEmail(String subject, String content) {
        EmailTask et = new EmailTask(subject, content);
        return et.doInBackground();
    }

    /**
     * Send a text email with an attachment
     * @param subject
     * @param content
     * @param fileSrc
     * @return
     * @throws AddressException
     * @throws MessagingException
     */
    private boolean sendTextWithAttachment(String subject, String content, String fileSrc) throws AddressException, MessagingException {
        try {
            Properties properties = new Properties();
            properties.put("mail.transport.protocol", protocol);
            properties.put("mail.smtp.host", smtpHost);
            properties.put("mail.smtp.port", port);
            properties.put("mail.smtp.auth", authorizeEnable);
            properties.put("mail.smtp.ssl.enable", sslEnable);
            properties.put("mail.debug", mailDebug);
            Session session = Session.getInstance(properties);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sendEmail));
            message.setRecipients(Message.RecipientType.TO, new InternetAddress[] {
                    new InternetAddress(receiveEmail1)
            });
            message.setSubject(subject);
            // Create a message
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(content);
            // Create multiple parts in message
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            // Create attachment in message
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(fileSrc);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(MimeUtility.encodeText(fileSrc));
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            // Create transport and send message with an attachment
            Transport transport = session.getTransport();
            transport.connect(sendEmail, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
