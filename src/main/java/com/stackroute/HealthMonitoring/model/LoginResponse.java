package com.stackroute.HealthMonitoring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class LoginResponse {
   private String email;
   private String accessToken; 
}
