package com.doctor.doctor.mapper;

import com.doctor.doctor.dto.Patient;
import com.doctor.doctor.entity.PatientEntity;
import com.doctor.doctor.request.PatientRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientEntity toEntity(PatientRequest request);

    Patient toDto(PatientEntity patientEntity);

    PatientEntity merge(@MappingTarget PatientEntity entity, PatientRequest request);
}
