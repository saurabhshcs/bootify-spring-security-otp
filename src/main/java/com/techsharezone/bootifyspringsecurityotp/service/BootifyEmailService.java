package com.techsharezone.bootifyspringsecurityotp.service;

/*
 * @created 25/11/2020 -00:31
 * @project bootify-spring-security-otp
 * @author  saurabhshcs
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class BootifyEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(BootifyEmailService.class);

    private JavaMailSender mailSender;

    private SimpleMailMessage message;

    public void sendOTPMsg(final String to, final String subject, final String msg) {

        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);

        LOG.info("BootifyEmailService: Email is sending to [{}] with subject [{}]", message.getTo(), message.getSubject());
        mailSender.send(message);
    }

}
