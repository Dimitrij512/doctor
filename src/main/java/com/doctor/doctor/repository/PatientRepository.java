package com.doctor.doctor.repository;


import com.doctor.doctor.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PatientRepository extends MongoRepository<Patient, String> {

    List<Patient> findAllByDoctorId(String doctorId);
}
