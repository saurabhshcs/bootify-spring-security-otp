package com.techsharezone.bootifyspringsecurityotp.controller;

/*
 * @created 25/11/2020 -01:27
 * @project bootify-spring-security-otp
 * @author  saurabhshcs
 */

import com.techsharezone.bootifyspringsecurityotp.service.BootifyEmailService;
import com.techsharezone.bootifyspringsecurityotp.service.BootifyOTPService;
import com.techsharezone.bootifyspringsecurityotp.util.EmailTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OtpController {

    private final static Logger LOG = LoggerFactory.getLogger(OtpController.class);

    @Autowired
    private BootifyOTPService otpService;

    @Autowired
    private BootifyEmailService emailService;

    @GetMapping("/generateOtp")
    public String generateOtp() {

        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        String userName = authentication.getName();

        Integer otp = otpService.generateOtp(userName);
        LOG.info("OTP [{}] is generated for the user [{}]", otp, userName);

        EmailTemplate emailTemplate = new EmailTemplate("templates/sendOtp.html");
        Map<String, String> replacements = new HashMap<>();
        replacements.put("User:", userName);
        replacements.put("OTP", otp.toString());

        String message = emailTemplate.getTemplate(replacements);

        emailService.sendOTPMsg("saurabhshcs@yahoo.com", "OTP-Spring Boot", message);

        return "otpPage";
    }

}
