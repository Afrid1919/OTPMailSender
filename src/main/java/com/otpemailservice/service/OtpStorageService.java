package com.otpemailservice.service;

import com.otpemailservice.entity.EmailOtpEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class OtpStorageService {
    private Map<String, EmailOtpEntity> otpStore = new HashMap<>();

    public void storeOtp(String email, String otp){
        EmailOtpEntity otpEntity = new EmailOtpEntity(email, otp, LocalDateTime.now().plusMinutes(5));
        otpStore.put(email, otpEntity);
    }

    public EmailOtpEntity getOtpDetails(String email){
        return otpStore.get(email);
    }

    public void removeOtp(String email){
        otpStore.remove(email);
    }
}
