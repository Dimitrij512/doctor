package com.doctor.doctor.service;

import com.doctor.doctor.dto.MedicalCard;

import com.doctor.doctor.exception.NotFoundException;
import com.doctor.doctor.mapper.DoctorNoteMapper;
import com.doctor.doctor.mapper.MedicalCardMapper;
import com.doctor.doctor.repository.MedicalCardRepository;
import com.doctor.doctor.request.DoctorNoteRequest;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MedicalCardService {

    private final MedicalCardRepository medicalCardRepository;

    private final SetupService setupService;

    private final ToothService toothService;

    public MedicalCardService(MedicalCardRepository medicalCardRepository, SetupService setupService,
            ToothService toothService) {
        this.medicalCardRepository = medicalCardRepository;
        this.setupService = setupService;
        this.toothService = toothService;
    }

    public void save(MedicalCard medicalCard) {
        medicalCardRepository.save(MedicalCardMapper.INSTANCE.toEntity(medicalCard));
    }

    public void updateDoctorId(String medicalCardId, String doctorId) {
        var medicalCard = findById(medicalCardId);
        medicalCard.setDoctorId(doctorId);

        var medicalCardUpdated = medicalCardRepository.save(MedicalCardMapper.INSTANCE.toEntity(medicalCard));

        setupService.updateDoctorIdForPatient(medicalCardId, medicalCardUpdated.getDoctorId());

        MedicalCardMapper.INSTANCE.toDto(medicalCardUpdated);
    }

    public void addDoctorNote(String medicalCardId, DoctorNoteRequest doctorNoteRequest) {
        var doctorNote = DoctorNoteMapper.INSTANCE.toDto(doctorNoteRequest);
        doctorNote.setId(UUID.randomUUID().toString());
        doctorNote.setCreatedDate(DateTime.now());

        var medicalCard = findById(medicalCardId);
        medicalCard.getDoctorNotes().add(doctorNote);

        save(medicalCard);
    }

    public MedicalCard findById(String id) {
        var entity = medicalCardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Medical card not found by id = %s", id)));

        var medicalCardDto = MedicalCardMapper.INSTANCE.toDto(entity);
        medicalCardDto.setToothList(toothService.findAllByByMedicalCardId(medicalCardDto.getId()));

        return medicalCardDto;
    }

    public MedicalCard findByPatientId(String patientId) {
        var medicalCardDto = MedicalCardMapper.INSTANCE
                .toDto(medicalCardRepository.findMedicalCardByPatientId(patientId));
        medicalCardDto.setToothList(toothService.findAllByByMedicalCardId(medicalCardDto.getId()));

        return medicalCardDto;
    }

    public List<MedicalCard> findAllByDoctorId(String doctorId) {
        return medicalCardRepository.findMedicalCardsByDoctorId(doctorId).stream().map(entity -> {

            var medicalCard = MedicalCardMapper.INSTANCE.toDto(entity);
            medicalCard.setToothList(toothService.findAllByByMedicalCardId(entity.getId()));

            return medicalCard;
        }).collect(Collectors.toList());
    }
}
