package com.doctor.doctor.repository;

import com.doctor.doctor.entity.PatientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PatientRepository extends MongoRepository<PatientEntity, String> {

    List<PatientEntity> findAllByDoctorId(String doctorId);

    PatientEntity findPatientEntityByMedicalCardId(String medicalCardId);
}
