package com.doctor.doctor.repository;

import com.doctor.doctor.entity.Tooth;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToothRepository extends MongoRepository<Tooth, String> {
}
