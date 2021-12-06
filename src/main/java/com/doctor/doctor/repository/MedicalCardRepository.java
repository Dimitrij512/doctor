package com.doctor.doctor.repository;

import com.doctor.doctor.entity.MedicalCardEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MedicalCardRepository extends MongoRepository<MedicalCardEntity, String> {

    List<MedicalCardEntity> findMedicalCardsByDoctorId(String doctorId);

    MedicalCardEntity findMedicalCardByPatientId(String patientId);
}
