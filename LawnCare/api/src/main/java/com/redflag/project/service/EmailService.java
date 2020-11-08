package com.redflag.project.service;

import org.springframework.context.annotation.Bean;

public interface EmailService {
    void sendSimpleMessage(String subject, String text);
}
