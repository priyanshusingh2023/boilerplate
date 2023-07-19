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

import com.stackroute.HealthMonitoring.Service.MedicalHistoryService;
import com.stackroute.HealthMonitoring.model.MedicalHistory;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class MedicalHistoryController {
	@Autowired
	private MedicalHistoryService medicalHistoryService;

	@PostMapping("/{patientId}/medical-history")
	public ResponseEntity<MedicalHistory> createMedicalHistory(@PathVariable Long patientId,
			@RequestBody MedicalHistory medicalHistory) {

		MedicalHistory createdMH = medicalHistoryService.createMedicalHistory(patientId, medicalHistory);
		if (createdMH != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdMH);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/{patientId}/medical-history")
	public ResponseEntity<List<MedicalHistory>> getMedicalHistory(@PathVariable Long patientId) {

		List<MedicalHistory> getMH = medicalHistoryService.getMedicalHistory(patientId);
		if (getMH != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(getMH);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}
