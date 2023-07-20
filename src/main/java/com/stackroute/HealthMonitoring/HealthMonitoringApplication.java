
package com.stackroute.HealthMonitoring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
public class HealthMonitoringApplication {

	// Main method to run the application
	public static void main(String[] args) {
		SpringApplication.run(HealthMonitoringApplication.class, args);
	}

}