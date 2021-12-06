package com.doctor.doctor.mapper;

import com.doctor.doctor.entity.DoctorNote;
import com.doctor.doctor.request.DoctorNoteRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorNoteMapper {

    DoctorNoteMapper INSTANCE = Mappers.getMapper(DoctorNoteMapper.class);

    DoctorNote toDto(DoctorNoteRequest request);
}
