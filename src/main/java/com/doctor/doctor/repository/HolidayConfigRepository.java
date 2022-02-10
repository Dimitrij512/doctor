package com.doctor.doctor.repository;

import com.doctor.doctor.entity.HolidayConfigEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HolidayConfigRepository extends MongoRepository<HolidayConfigEntity, String> {

    List<HolidayConfigEntity> findHolidayConfigsByDoctorId(String doctorId);

    List<HolidayConfigEntity> findHolidayConfigsByGlobalIsTrue();
}
