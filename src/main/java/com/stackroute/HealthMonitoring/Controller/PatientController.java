package com.stackroute.HealthMonitoring.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.HealthMonitoring.Service.PatientService;
import com.stackroute.HealthMonitoring.model.Patient;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*")
public class PatientController {
    @Autowired
    private PatientService patientService;

    // create a patient
    @PostMapping("/createPatient")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient newPatient = patientService.addPatient(patient);
        if (newPatient != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newPatient);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(newPatient);
        }

    }

    // create a restcontroller method to get a patient by id
    @GetMapping("/getPatient/{patientId}")
    public ResponseEntity<?> getPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(patientService.getPatient(patientId));
    }

    // create a restcontroller method to update a patient
    @PutMapping("/updatePatient/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long patientId, @RequestBody Patient patient) {
        patient.setPatientId(patientId);
        Patient updatedPatient = patientService.updatePatient(patient);
        if (updatedPatient != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedPatient);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(updatedPatient);
        }

    }

    // create a restcontroller method to delete a patient
  // This function takes a patient ID as input and deletes the patient with that ID.

  @GetMapping("/getPatientById/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long patientId) {
        Optional<Patient> patient = patientService.getPatient(patientId);
        if (patient.isPresent()) {
            return ResponseEntity.ok(patient.get());
        }
        return ResponseEntity.notFound().build();
    }

    // create a restcontroller method to get all patients
    @GetMapping("/getAllPatients")
    public ResponseEntity<?> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }
}
