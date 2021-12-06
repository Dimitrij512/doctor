package com.doctor.doctor.mapper;

import com.doctor.doctor.dto.Doctor;
import com.doctor.doctor.entity.DoctorEntity;
import com.doctor.doctor.request.DoctorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    Doctor toDto(DoctorEntity doctorEntity);

    DoctorEntity toEntity(DoctorRequest doctorRequest);
}
