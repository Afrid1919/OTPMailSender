package com.otpemailservice.controller;

import com.otpemailservice.entity.EmailOtpEntity;
import com.otpemailservice.service.EmailOtpService;
import com.otpemailservice.service.OtpStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/otp")
public class EmailOtpController {

    @Autowired
    private EmailOtpService emailOtpService;
    @Autowired
    private OtpStorageService otpStorageService;

    @PostMapping("/send")
    public String sendOtp(@RequestParam String email){
        emailOtpService.sendOtp(email);
        return "OTP send to "+ email;
    }

    @PostMapping("/verify")
    public String verifyOtp(@RequestParam String email, @RequestParam String otp){
        EmailOtpEntity emailOtpEntity = otpStorageService.getOtpDetails(email);

        if(emailOtpEntity == null){
            return "No OTP found for this email";
        }

        if(emailOtpEntity.getExpirationTime().isBefore(LocalDateTime.now())){
            otpStorageService.removeOtp(email);
            return "OTP has expired!...";
        }

        if(!emailOtpEntity.getOtp().equals(otp)){
            return "Invalid OTP!!!";
        }

        otpStorageService.removeOtp(email);
        return "OTP verified successfully";
    }

}
