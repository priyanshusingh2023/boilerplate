package com.stackroute.HealthMonitoring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.HealthMonitoring.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
