package com.doctor.doctor.service;

import com.doctor.doctor.dto.Patient;
import com.doctor.doctor.entity.*;
import com.doctor.doctor.enums.ToothNumberEnum;
import com.doctor.doctor.enums.ToothPositionEnum;
import com.doctor.doctor.enums.ToothState;
import com.doctor.doctor.mapper.PatientMapper;
import com.doctor.doctor.repository.DoctorRepository;
import com.doctor.doctor.repository.MedicalCardRepository;
import com.doctor.doctor.repository.PatientRepository;
import com.doctor.doctor.repository.ToothRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SetupService {

    private final MedicalCardRepository medicalCardRepository;

    private final ToothRepository toothRepository;

    private final PatientRepository patientRepository;

    public SetupService(MedicalCardRepository medicalCardRepository, ToothRepository toothRepository,
            PatientRepository patientRepository) {
        this.medicalCardRepository = medicalCardRepository;
        this.toothRepository = toothRepository;
        this.patientRepository = patientRepository;
    }

    @Transactional
    public Patient setupAndSavePatient(PatientEntity patientEntity) {

        MedicalCardEntity medicalCard = new MedicalCardEntity();
        Optional.ofNullable(patientEntity.getDoctorId()).ifPresent(medicalCard::setDoctorId);
        medicalCard.setPatientId(patientEntity.getId());

        var medicalCardCreated = medicalCardRepository.save(medicalCard);
        createTeethForMedicalCard(medicalCard.getId());

        patientEntity.setMedicalCardId(medicalCardCreated.getId());

        return PatientMapper.INSTANCE.toDto(patientRepository.save(patientEntity));
    }

    public void updateDoctorIdForMedicalCard(String patientId, String doctorId) {
        var medicalCard = medicalCardRepository.findMedicalCardByPatientId(patientId);
        if (Objects.nonNull(doctorId) && !doctorId.equals(medicalCard.getDoctorId())) {
            medicalCard.setDoctorId(doctorId);
            medicalCardRepository.save(medicalCard);
        }
    }

    public void updateDoctorIdForPatient(String medicalCardId, String doctorId) {
        var patientEntity = patientRepository.findPatientEntityByMedicalCardId(medicalCardId);

        if (Objects.nonNull(doctorId) && !doctorId.equals(patientEntity.getDoctorId())) {
            patientEntity.setDoctorId(doctorId);
            patientRepository.save(patientEntity);
        }
    }

    private List<ToothEntity> createTeethForMedicalCard(String medicalCardId) {

        List<ToothEntity> listTeethLeftUpper = createDefaultTeeth(medicalCardId, ToothPositionEnum.LEFT_UPPER);
        List<ToothEntity> listTeethLeftBottom = createDefaultTeeth(medicalCardId, ToothPositionEnum.LEFT_BOTTOM);
        List<ToothEntity> listTeethRightUpper = createDefaultTeeth(medicalCardId, ToothPositionEnum.RIGHT_UPPER);
        List<ToothEntity> listTeethRightBottom = createDefaultTeeth(medicalCardId, ToothPositionEnum.RIGHT_BOTTOM);

        List<ToothEntity> allTeeth = Stream
                .of(listTeethLeftUpper, listTeethLeftBottom, listTeethRightUpper, listTeethRightBottom)
                .flatMap(Collection::stream).collect(Collectors.toList());

        return toothRepository.saveAll(allTeeth);
    }

    private List<ToothEntity> createDefaultTeeth(String medicalCardId, ToothPositionEnum positionEnum) {

        List<ToothEntity> toothList = new ArrayList<>();

        Arrays.stream(ToothNumberEnum.values()).forEach(toothNumberEnum -> {
            ToothEntity toothEntity = new ToothEntity();
            toothEntity.setMedicalCardId(medicalCardId);
            toothEntity.setPosition(positionEnum);
            toothEntity.setToothNumber(toothNumberEnum);
            toothEntity.setToothState(ToothState.HEALTHY);
            toothList.add(toothEntity);
        });

        return toothList;
    }

    @Transactional
    public void deletePatientById(String patientId) {
        var medicalCard = medicalCardRepository.findMedicalCardByPatientId(patientId);
        toothRepository.deleteAllByMedicalCardId(medicalCard.getId());
        medicalCardRepository.delete(medicalCard);
        patientRepository.deleteById(patientId);
    }
}
