package com.doctor.doctor.repository;

import com.doctor.doctor.entity.DoctorEntity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<DoctorEntity, String> {

    boolean existsById(String id);
}
