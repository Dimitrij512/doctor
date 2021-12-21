package com.doctor.doctor.mapper;

import com.doctor.doctor.dto.Appointment;
import com.doctor.doctor.entity.AppointmentEntity;
import com.doctor.doctor.request.AppointmentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppointmentMapper {

    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    Appointment toDto(AppointmentEntity appointmentEntity);

    AppointmentEntity toEntity(AppointmentRequest dto);

    AppointmentEntity merge(@MappingTarget AppointmentEntity entity, AppointmentRequest request);
}
