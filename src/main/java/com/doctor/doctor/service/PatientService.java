package com.doctor.doctor.service;

import com.doctor.doctor.entity.Patient;
import com.doctor.doctor.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient findById(String id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
}
