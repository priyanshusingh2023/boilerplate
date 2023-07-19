package com.stackroute.HealthMonitoring.Service;

import java.util.List;

import com.stackroute.HealthMonitoring.Exceptions.ResourceNotFoundException;
import com.stackroute.HealthMonitoring.model.Vitals;

public interface VitalsService {
    List<Vitals> getPatientVitals(Long patientId) throws ResourceNotFoundException;

    Vitals recordPatientVitals(Long patientId, Vitals vitals) throws ResourceNotFoundException;

}
