package com.doctor.doctor.mapper;

import com.doctor.doctor.dto.Doctor;
import com.doctor.doctor.dto.MedicalCard;
import com.doctor.doctor.entity.DoctorEntity;
import com.doctor.doctor.entity.MedicalCardEntity;
import com.doctor.doctor.request.DoctorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicalCardMapper {

    MedicalCardMapper INSTANCE = Mappers.getMapper(MedicalCardMapper.class);

    MedicalCard toDto(MedicalCardEntity medicalCardEntity);

    MedicalCardEntity toEntity(MedicalCard medicalCard);
}
