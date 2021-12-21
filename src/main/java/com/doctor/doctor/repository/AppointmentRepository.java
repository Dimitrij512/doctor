package com.doctor.doctor.repository;

import com.doctor.doctor.entity.AppointmentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends MongoRepository<AppointmentEntity, String> {

    List<AppointmentEntity> findAllByStartGreaterThanEqualAndEndLessThanEqual(Date start, Date end);
}
