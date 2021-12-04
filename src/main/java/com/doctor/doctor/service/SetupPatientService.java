package com.doctor.doctor.service;

import com.doctor.doctor.entity.DentalCard;
import com.doctor.doctor.entity.MedicalCard;
import com.doctor.doctor.entity.Patient;
import com.doctor.doctor.entity.Tooth;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SetupPatientService {

    private final MedicalCardService medicalCardService;

    private final ToothService toothService;

    public SetupPatientService(MedicalCardService medicalCardService, ToothService toothService) {
        this.medicalCardService = medicalCardService;
        this.toothService = toothService;
    }

    @Transactional
    public Patient setupPatient(Patient patient) {

        MedicalCard medicalCard = new MedicalCard();
        medicalCard.setPatientId(patient.getId());
        medicalCard.setDentalCard(createDentalCard());

        var medicalCardCreated = medicalCardService.save(medicalCard);

        patient.setMedicalCardId(medicalCardCreated.getId());

        return patient;
    }

    private DentalCard createDentalCard() {

        String dentalCardId = UUID.randomUUID().toString();
        var toothIds = toothService.createTeethForDentalCard(dentalCardId).stream()
                .map(Tooth::getId)
                .collect(Collectors.toList());

        DentalCard dentalCard = new DentalCard();
        dentalCard.setId(dentalCardId);
        dentalCard.setToothIds(toothIds);

        return dentalCard;
    }
}
