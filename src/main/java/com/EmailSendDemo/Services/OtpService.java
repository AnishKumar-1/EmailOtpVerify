package com.EmailSendDemo.Services;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class OtpService{
	
    private final Map<String, String> otpStorage = new ConcurrentHashMap<>();
    private final Random random = new Random();


    public String generateOtp(String email) {
        String otp = String.valueOf(100000 + random.nextInt(900000)); // Generate 6-digit OTP
        otpStorage.put(email, otp);
        return otp;
    }

    public boolean validateOtp(String email, String enteredOtp) {
        return otpStorage.containsKey(email) && otpStorage.get(email).equals(enteredOtp);
    }

    public void removeOtp(String email) {
        otpStorage.remove(email);
    }
}
