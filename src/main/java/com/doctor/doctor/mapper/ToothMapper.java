package com.doctor.doctor.mapper;

import com.doctor.doctor.dto.Patient;
import com.doctor.doctor.dto.Tooth;
import com.doctor.doctor.entity.PatientEntity;
import com.doctor.doctor.entity.ToothEntity;
import com.doctor.doctor.request.PatientRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ToothMapper {

    ToothMapper INSTANCE = Mappers.getMapper(ToothMapper.class);

    ToothEntity toEntity(Tooth dto);

    Tooth toDto(ToothEntity entity);
}
