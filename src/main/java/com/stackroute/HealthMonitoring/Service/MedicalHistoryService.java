package com.stackroute.HealthMonitoring.Service;

import java.util.List;

import com.stackroute.HealthMonitoring.model.MedicalHistory;

public interface MedicalHistoryService {
    MedicalHistory createMedicalHistory(Long patientId, MedicalHistory medicalHistory);

    List<MedicalHistory> getMedicalHistory(Long patientId);
}
