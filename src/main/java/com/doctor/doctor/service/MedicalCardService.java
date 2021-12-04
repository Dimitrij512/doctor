package com.doctor.doctor.service;

import com.doctor.doctor.entity.Doctor;
import com.doctor.doctor.entity.DoctorNote;
import com.doctor.doctor.entity.MedicalCard;
import com.doctor.doctor.repository.MedicalCardRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

@Service
public class MedicalCardService {
    private final MedicalCardRepository medicalCardRepository;
    public MedicalCardService(MedicalCardRepository medicalCardRepository) {
        this.medicalCardRepository = medicalCardRepository;
    }

    public MedicalCard save(MedicalCard medicalCard) {
        return medicalCardRepository.save(medicalCard);
    }

    public MedicalCard updateDoctorId(String medicalCardId, String doctorId) {
        var medicalCard = findById(medicalCardId);
        medicalCard.setDoctorId(doctorId);

        return medicalCardRepository.save(medicalCard);
    }

    public void addDoctorNote(String medicalCardId, DoctorNote doctorNote) {
        var medicalCard = findById(medicalCardId);
        medicalCard.getDoctorNotes().add(doctorNote);

        save(medicalCard);
    }

    public MedicalCard findById(String id) {
        return medicalCardRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Medical card not found by id = %s", id)));
    }

    public MedicalCard findByPatientId(String patientId) {
        return medicalCardRepository.findMedicalCardByPatientId(patientId);
    }

    public List<MedicalCard> findAllByDoctorId(String doctorId) {
        return medicalCardRepository.findMedicalCardsByDoctorId(doctorId);
    }

    public List<MedicalCard> findAll() {
        return medicalCardRepository.findAll();
    }
}
