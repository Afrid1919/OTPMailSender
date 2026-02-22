package com.otpemailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OtpEmailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtpEmailServiceApplication.class, args);
		System.err.println("App is running...");
	}

}
