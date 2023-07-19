package com.stackroute.HealthMonitoring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.HealthMonitoring.model.Prescriptions;

public interface PrescriptionRepo extends JpaRepository<Prescriptions, Long> {

}
