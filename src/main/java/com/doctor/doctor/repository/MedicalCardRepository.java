package com.doctor.doctor.repository;

import com.doctor.doctor.entity.Doctor;
import com.doctor.doctor.entity.MedicalCard;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MedicalCardRepository extends MongoRepository<MedicalCard, String> {

    List<MedicalCard> findMedicalCardsByDoctorId(String doctorId);

    MedicalCard findMedicalCardByPatientId(String patientId);
}
