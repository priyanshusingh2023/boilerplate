package com.stackroute.HealthMonitoring.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.HealthMonitoring.Service.PatientService;
import com.stackroute.HealthMonitoring.model.Patient;
import com.stackroute.HealthMonitoring.repo.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
        Patient savedPateint = patientRepository.save(patient);
        if (savedPateint != null) {
            return savedPateint;
        } else {
            return null;
        }
    }

    @Override
    public Optional<Patient> getPatient(Long patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);
       return patient;

    }

    @Override
    public Patient updatePatient(Patient patient) {
        Optional<Patient> existingPatient = patientRepository.findById(patient.getPatientId());
        if (existingPatient.isPresent()) {
            Patient updatedPatient = existingPatient.get();

            updatedPatient.setPatientName(patient.getPatientName());
            updatedPatient.setPatientName(patient.getPatientName());
            updatedPatient.setPatientPhone(patient.getPatientPhone());
            return patientRepository.save(updatedPatient);
        } else {
            return null;
        }

    }

    @Override
    public boolean deletePatient(Long patientId) {
        Optional<Patient> existingPatient = patientRepository.findById(patientId);
        if (existingPatient.isPresent()) {
            // Patient deletedPatient = existingPatient.get();
            patientRepository.deleteById(patientId);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
