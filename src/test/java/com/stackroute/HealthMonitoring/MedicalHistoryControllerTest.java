package com.stackroute.HealthMonitoring;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.stackroute.HealthMonitoring.Controller.MedicalHistoryController;
import com.stackroute.HealthMonitoring.ServiceImpl.MedicalHistoryServiceImpl;
import com.stackroute.HealthMonitoring.model.MedicalHistory;
import com.stackroute.HealthMonitoring.model.Prescriptions;
import com.stackroute.HealthMonitoring.repo.MedicalHistoryRepo;

@SpringBootTest
public class MedicalHistoryControllerTest {
    @Mock
    private MedicalHistoryRepo medicalHistoryRepo;

    @Mock
    private MedicalHistoryServiceImpl medicalHistoryServiceImpl;

    // @Mock
    // private MedicalHistoryService medicalHistoryService;

    @Mock
    private MedicalHistoryController medicalHistoryController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMedicalHistory_Success() {
        long patientId = 20;
        MedicalHistory medicalHistory1 = new MedicalHistory();
        List<MedicalHistory> medicalHistoryList = new ArrayList<>();
        medicalHistory1.setPatientId(patientId);
        medicalHistory1.setTimestamp(null);
        medicalHistory1.setDoctorId(1);
        medicalHistory1.setNotes("notes");
        medicalHistory1.setDiagnosis("diagnosis");

        List<Prescriptions> prescriptionList = new ArrayList<>();
        Prescriptions prescription1 = new Prescriptions();
        prescription1.setPrescriptionId(1L);
        prescription1.setMedication("Aspirin");
        prescription1.setDosage("1");
        prescription1.setFrequency("1");
        prescription1.setStartDate("2020-01-01");
        prescription1.setEndDate("2020-01-01");

        prescriptionList.add(prescription1);

        medicalHistory1.setPrescriptions(prescriptionList);

        medicalHistoryList.add(medicalHistory1);

        when(medicalHistoryRepo.findByPatientId(patientId)).thenReturn(medicalHistoryList);
        when(medicalHistoryServiceImpl.getMedicalHistory(patientId)).thenReturn(medicalHistoryList);
        when(medicalHistoryController.getMedicalHistory(patientId))
                .thenReturn(new ResponseEntity<List<MedicalHistory>>(medicalHistoryList, HttpStatus.CREATED));
        ResponseEntity<List<MedicalHistory>> responseEntity = medicalHistoryController.getMedicalHistory(patientId);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(medicalHistoryList, responseEntity.getBody());
    }

    @Test
    public void testRecordMedicalHistory_Success() {
        long patientId = 8;
        MedicalHistory medicalHistory1 = new MedicalHistory();
        // List<MedicalHistory> medicalHistoryList = new ArrayList<>();
        medicalHistory1.setPatientId(patientId);
        medicalHistory1.setTimestamp(null);
        medicalHistory1.setDoctorId(1);
        medicalHistory1.setNotes("notes");
        medicalHistory1.setDiagnosis("diagnosis");

        List<Prescriptions> prescriptionList = new ArrayList<>();
        Prescriptions prescription1 = new Prescriptions();
        prescription1.setPrescriptionId(1L);
        prescription1.setMedication("Aspirin");
        prescription1.setDosage("1");
        prescription1.setFrequency("1");
        prescription1.setStartDate("2020-01-01");
        prescription1.setEndDate("2020-01-01");

        prescriptionList.add(prescription1);

        medicalHistory1.setPrescriptions(prescriptionList);

        // medicalHistoryList.add(medicalHistory1);
        // when(MedicalHistoryRepo.save(any(MedicalHistory.class))).thenReturn(medicalHistory1);
        when(medicalHistoryRepo.save(medicalHistory1)).thenReturn(medicalHistory1);
        when(medicalHistoryServiceImpl.createMedicalHistory(patientId, medicalHistory1)).thenReturn(medicalHistory1);
        when(medicalHistoryController.createMedicalHistory(patientId, medicalHistory1))
                .thenReturn(new ResponseEntity<MedicalHistory>(medicalHistory1, HttpStatus.CREATED));
        ResponseEntity<MedicalHistory> responseEntity = medicalHistoryController.createMedicalHistory(patientId,
                medicalHistory1);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(medicalHistory1, responseEntity.getBody());

    }

}
