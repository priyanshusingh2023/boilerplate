package com.stackroute.HealthMonitoring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.HealthMonitoring.model.Vitals;

public interface VitalsRepo extends JpaRepository<Vitals, Long> {

}
