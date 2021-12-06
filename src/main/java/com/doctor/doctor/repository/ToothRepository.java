package com.doctor.doctor.repository;

import com.doctor.doctor.entity.ToothEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ToothRepository extends MongoRepository<ToothEntity, String> {

    List<ToothEntity> findAllByMedicalCardId(String medicalCardId);
}
