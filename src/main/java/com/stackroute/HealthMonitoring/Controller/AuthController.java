package com.stackroute.HealthMonitoring.Controller;
import com.stackroute.HealthMonitoring.config.JwtTokenUtility;
import com.stackroute.HealthMonitoring.model.LoginRequest;
import com.stackroute.HealthMonitoring.model.LoginResponse;
import com.stackroute.HealthMonitoring.model.User;
import com.stackroute.HealthMonitoring.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;

/**
 * @author Priyanshu Singh
 */

@RestController
@RequestMapping("/auth")
public class AuthController {
   @Autowired
    private UserRepo userRepo;
    @Autowired 
    AuthenticationManager authManager;
	@Autowired 
   private JwtTokenUtility jwtUtil;
    @Value("${jwt.secretKey}")
    private String secretKey;

        @PostMapping("/login")
           public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        
        try {
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							loginRequest.getEmail(), loginRequest.getPassword())
			);
			
			User user = (User) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			LoginResponse response = new LoginResponse(user.getEmail(), accessToken);
			
			return ResponseEntity.ok().body(response);
			
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
         }
}

