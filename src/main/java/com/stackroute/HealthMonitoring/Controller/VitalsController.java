package com.stackroute.HealthMonitoring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.HealthMonitoring.Exceptions.ResourceNotFoundException;
import com.stackroute.HealthMonitoring.Service.VitalsService;
import com.stackroute.HealthMonitoring.model.Vitals;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*")
public class VitalsController {

    @Autowired
    private VitalsService vitalsService;

    @PostMapping("/{patientId}/vitals")
    public ResponseEntity<Vitals> recordPatientVitals(@PathVariable Long patientId, @RequestBody Vitals vitals) throws ResourceNotFoundException {
        Vitals newVitals = vitalsService.recordPatientVitals(patientId, vitals);
        if(newVitals != null) {
        	return ResponseEntity.status(HttpStatus.CREATED).body(newVitals);
        }else {
        	return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{patientId}/vitals")
    public ResponseEntity<List<Vitals>> getPatientVitals(@PathVariable Long patientId) throws ResourceNotFoundException {
        List<Vitals> vitals = vitalsService.getPatientVitals(patientId);
        if(vitals != null) {
        	return ResponseEntity.status(HttpStatus.OK).body(vitals);
        }else {
        	return ResponseEntity.notFound().build();
        }
        
    }
}
