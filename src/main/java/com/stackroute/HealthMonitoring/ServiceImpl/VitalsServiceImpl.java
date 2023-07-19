package com.stackroute.HealthMonitoring.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.HealthMonitoring.Exceptions.ResourceNotFoundException;
import com.stackroute.HealthMonitoring.Service.VitalsService;
import com.stackroute.HealthMonitoring.model.Patient;
import com.stackroute.HealthMonitoring.model.Vitals;
import com.stackroute.HealthMonitoring.repo.PatientRepository;
import com.stackroute.HealthMonitoring.repo.VitalsRepo;

@Service
public class VitalsServiceImpl implements VitalsService {

    @Autowired
    private VitalsRepo vitalRepo;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Vitals> getPatientVitals(Long patientId) throws ResourceNotFoundException {
        Optional<Patient> originalPatient = patientRepository.findById(patientId);
        if (!originalPatient.isPresent()) {
            throw new ResourceNotFoundException("Patient not found with ID: " + patientId);
        } else {
            Patient patient = originalPatient.get();
            return patient.getVitals();
        }
    }

    @Override
    public Vitals recordPatientVitals(Long patientId, Vitals vitals) throws ResourceNotFoundException {
        Optional<Patient> originalPatient = patientRepository.findById(patientId);
        if (!originalPatient.isPresent()) {
            throw new ResourceNotFoundException("Patient not found with ID: " + patientId);
        } else {
            Patient patient = originalPatient.get();
            Vitals vitals1 = new Vitals();
            vitals1.setPatient(patient);
            vitals1.setTimestamp(LocalDateTime.now());
            vitals1.setBloodPressure(vitals.getBloodPressure());
            vitals1.setHeartRate(vitals.getHeartRate());
            vitals1.setTemperature(vitals.getTemperature());
            // vitals1.setPrescriptions(vitals.getPrescriptions());
            return vitalRepo.save(vitals1);
        }
    }

}
