package com.doctor.doctor.service;

import com.doctor.doctor.dto.Patient;
import com.doctor.doctor.entity.PatientEntity;
import com.doctor.doctor.exception.NotFoundException;
import com.doctor.doctor.mapper.PatientMapper;
import com.doctor.doctor.repository.PatientRepository;
import com.doctor.doctor.request.PatientRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    private final SetupService setupService;

    private final DoctorService doctorService;

    public PatientService(PatientRepository patientRepository, SetupService setupService, DoctorService doctorService) {

        this.patientRepository = patientRepository;
        this.setupService = setupService;
        this.doctorService = doctorService;
    }

    @Transactional
    public Patient create(PatientRequest request) {

        if (Objects.nonNull(request.getDoctorId()) && doctorService.notExistById(request.getDoctorId())) {
            throw new NotFoundException(String.format("Doctor does not exist by id= %s", request.getDoctorId()));
        }

        PatientEntity patientCreatedEntity = patientRepository.save(PatientMapper.INSTANCE.toEntity(request));

        return setupService.setupAndSavePatient(patientCreatedEntity);
    }

    public Patient update(String patientId, PatientRequest request) {

        if (Objects.nonNull(request.getDoctorId()) && doctorService.notExistById(request.getDoctorId())) {
            throw new NotFoundException(String.format("Doctor does not exist by id= %s", request.getDoctorId()));
        }

        PatientEntity patientFound = patientRepository.findById(patientId).orElseThrow(
                () -> new NotFoundException(String.format("Patient does not exist by id= %s", request.getDoctorId())));

        PatientEntity patientCreatedEntity = patientRepository
                .save(PatientMapper.INSTANCE.merge(patientFound, request));

        setupService.updateDoctorIdForMedicalCard(patientId, patientCreatedEntity.getDoctorId());

        return PatientMapper.INSTANCE.toDto(patientCreatedEntity);
    }

    public Patient findById(String id) {
        PatientEntity patientEntity = patientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Not found patient by id = %s", id)));

        return PatientMapper.INSTANCE.toDto(patientEntity);
    }

    public List<Patient> findAllByIds(List<String> listId) {
        return patientRepository.findByIdIn(listId).stream().map(PatientMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public List<Patient> findAllByDoctorId(String doctorId) {
        return patientRepository.findAllByDoctorId(doctorId).stream().map(PatientMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public List<Patient> findAll() {
        return patientRepository.findAll().stream().map(PatientMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    public void deleteById(String patientId) {
        setupService.deletePatientById(patientId);
    }
}
