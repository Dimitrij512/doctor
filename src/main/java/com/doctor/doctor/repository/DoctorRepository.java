package com.doctor.doctor.repository;

import com.doctor.doctor.entity.Doctor;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
}
