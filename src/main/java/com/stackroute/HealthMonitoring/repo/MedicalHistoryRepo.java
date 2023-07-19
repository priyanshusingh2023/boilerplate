package com.stackroute.HealthMonitoring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.HealthMonitoring.model.MedicalHistory;

public interface MedicalHistoryRepo extends JpaRepository<MedicalHistory, Long> {
    List<MedicalHistory> findByPatientId(Long patientId);
}
