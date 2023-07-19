package com.stackroute.HealthMonitoring.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Priyanshu Singh
 */
@Data
@Getter
@Setter

public class LoginRequest {
 private String email;
 private String password;
}

