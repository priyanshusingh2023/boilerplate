package com.stackroute.HealthMonitoring.Controller;
import com.stackroute.HealthMonitoring.model.User;
import com.stackroute.HealthMonitoring.Service.HealthCProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200/") 
@RestController
@RequestMapping("/hprovider")
public class UserController {

    @Autowired
    private HealthCProviderService healthCareProviderService;

    

    @PostMapping("/register")
    public ResponseEntity<?> registerHealthCareProvider(@RequestBody User user) {
        try {
           User savedUser=healthCareProviderService.registerHealthCareProvider(user);

            return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed: " + e.getMessage());
        }
    }
}
