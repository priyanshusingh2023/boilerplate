package com.stackroute.HealthMonitoring.Service;

import java.util.List;
import java.util.Optional;

import com.stackroute.HealthMonitoring.model.Patient;

public interface PatientService {
    Patient addPatient(Patient patient);

    Optional<Patient> getPatient(Long patientId);

    Patient updatePatient(Patient patient);

    boolean deletePatient(Long patientId);

    List<Patient> getAllPatients();
}
