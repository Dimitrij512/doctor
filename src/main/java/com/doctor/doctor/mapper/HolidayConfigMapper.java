package com.doctor.doctor.mapper;

import com.doctor.doctor.dto.HolidayConfig;
import com.doctor.doctor.entity.HolidayConfigEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HolidayConfigMapper {

    HolidayConfigMapper INSTANCE = Mappers.getMapper(HolidayConfigMapper.class);

    HolidayConfig toDto(HolidayConfigEntity holidayConfigEntity);

    HolidayConfigEntity toEntity(HolidayConfig dto);

    HolidayConfigEntity merge(@MappingTarget HolidayConfigEntity entity, HolidayConfig dto);

}
