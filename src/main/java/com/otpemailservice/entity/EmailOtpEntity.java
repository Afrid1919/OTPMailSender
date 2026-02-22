package com.otpemailservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EmailOtpEntity {
    private String email;
    private String otp;
    private LocalDateTime expirationTime;

}
