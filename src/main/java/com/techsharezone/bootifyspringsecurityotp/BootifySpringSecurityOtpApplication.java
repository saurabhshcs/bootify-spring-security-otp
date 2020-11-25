package com.techsharezone.bootifyspringsecurityotp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class BootifySpringSecurityOtpApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootifySpringSecurityOtpApplication.class, args);
	}

}
