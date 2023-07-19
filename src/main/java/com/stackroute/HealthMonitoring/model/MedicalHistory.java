package com.stackroute.HealthMonitoring.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="medical_history")
public class MedicalHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="medical_history_id")
	private Long medicalHistoryId;
	
	private Long patientId;
	
	private LocalDateTime timestamp;
    
    @Column(name = "doctor_id")
    private int doctorId;
    
    @Column(name = "notes")
    private String notes;
    
    @Column(name = "diagnosis")
    private String diagnosis;
    
    @OneToMany
    @JoinColumn(name = "medical_history_id")
    private List<Prescriptions> prescriptions;
    


}
