package com.stackroute.HealthMonitoring.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.HealthMonitoring.Service.MedicalHistoryService;
import com.stackroute.HealthMonitoring.model.MedicalHistory;
import com.stackroute.HealthMonitoring.model.Patient;
import com.stackroute.HealthMonitoring.model.Prescriptions;
import com.stackroute.HealthMonitoring.repo.MedicalHistoryRepo;
import com.stackroute.HealthMonitoring.repo.PatientRepository;
import com.stackroute.HealthMonitoring.repo.PrescriptionRepo;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {
    @Autowired
    private MedicalHistoryRepo medicalHistoryRepo;

    @Autowired
    private PatientRepository pateintRepo;

    @Autowired
    private PrescriptionRepo prescriptionRepo;

    @Override
    public MedicalHistory createMedicalHistory(Long patientId, MedicalHistory medicalHistory) {
        Optional<Patient> patientSearch = pateintRepo.findById(patientId);
        if (patientSearch.isPresent()) {
            MedicalHistory mh = new MedicalHistory();
            mh.setPatientId(patientId);
            mh.setTimestamp(LocalDateTime.now());
            mh.setDoctorId(medicalHistory.getDoctorId());
            mh.setNotes(medicalHistory.getNotes());
            mh.setDiagnosis(medicalHistory.getDiagnosis());
            List<Prescriptions> presList = new ArrayList<>();
            for (Prescriptions ppp : medicalHistory.getPrescriptions()) {
                Prescriptions presc = new Prescriptions();

                presc.setMedication(ppp.getMedication());
                presc.setDosage(ppp.getDosage());
                presc.setFrequency(ppp.getFrequency());
                presc.setStartDate(ppp.getStartDate());
                presc.setEndDate(ppp.getEndDate());

                Prescriptions savedPrescriptions = prescriptionRepo.save(presc);
                if (savedPrescriptions != null) {
                    presList.add(presc);
                }
            }
            mh.setPrescriptions(presList);

            return medicalHistoryRepo.save(mh);
        } else {
            return null;
        }

    }

    @Override
    public List<MedicalHistory> getMedicalHistory(Long patientId) {
        Optional<Patient> patientSearch = pateintRepo.findById(patientId);
        if (patientSearch.isPresent()) {
            return medicalHistoryRepo.findByPatientId(patientId);
        } else {
            return null;
        }
    }

}
