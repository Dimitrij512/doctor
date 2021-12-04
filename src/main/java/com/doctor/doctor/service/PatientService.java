package com.doctor.doctor.service;

import com.doctor.doctor.entity.DentalCard;
import com.doctor.doctor.entity.MedicalCard;
import com.doctor.doctor.entity.Patient;
import com.doctor.doctor.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    private final SetupPatientService setupPatientService;

    public PatientService(PatientRepository patientRepository, SetupPatientService setupPatientService) {

        this.patientRepository = patientRepository;
        this.setupPatientService = setupPatientService;
    }

    @Transactional
    public Patient create(Patient patient) {

        var patientCreated = patientRepository.save(patient);
        var patientSetup =  setupPatientService.setupPatient(patientCreated);

        return patientRepository.save(patientSetup);
    }

    public Patient findById(String id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> findAllByDoctorId(String doctorId) {
        return patientRepository.findAllByDoctorId(doctorId);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
}
