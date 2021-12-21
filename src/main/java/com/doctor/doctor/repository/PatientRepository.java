package com.doctor.doctor.repository;

import com.doctor.doctor.entity.PatientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PatientRepository extends MongoRepository<PatientEntity, String> {

    List<PatientEntity> findAllByDoctorId(String doctorId);

    List<PatientEntity> findByIdIn(List<String> ids);

    PatientEntity findPatientEntityByMedicalCardId(String medicalCardId);
}
