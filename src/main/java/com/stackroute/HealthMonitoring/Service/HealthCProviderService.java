package com.stackroute.HealthMonitoring.Service;

import com.stackroute.HealthMonitoring.model.User;
import com.stackroute.HealthMonitoring.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HealthCProviderService {
private final UserRepo userRepo;
private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public HealthCProviderService(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
       
    }

    public User registerHealthCareProvider(User user) {
        // Perform necessary logic for registering the health care provider
        // Encrypt/hash the password before saving the user data
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        User savedUser = userRepo.save(user);
        // Save the user data to the database or any other storage mechanism
        // Example implementation:
        // Save the user object to the database or any other storage mechanism
        return savedUser;
    }
}

