package com.stackroute.HealthMonitoring.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "vitals")
public class Vitals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vitalsId;

    private LocalDateTime timestamp;

    @Column(name = "blood_pressure")
    private String bloodPressure;

    @Column(name = "heart_rate")
    private int heartRate;

    @Column(name = "temperature")
    private double temperature;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany
    @JoinColumn(name = "vital_id")
    private List<Prescriptions> prescriptions;
}