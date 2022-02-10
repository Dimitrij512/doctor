package com.doctor.doctor.mapper;

import com.doctor.doctor.dto.HolidayConfig;
import com.doctor.doctor.entity.HolidayConfigEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HolidayConfigMapper {

    HolidayConfigMapper INSTANCE = Mappers.getMapper(HolidayConfigMapper.class);

    HolidayConfig toDto(HolidayConfigEntity holidayConfigEntity);

    @Mapping(target = "id", ignore = true)
    HolidayConfigEntity toEntity(HolidayConfig dto);

    @Mapping(target = "id", ignore = true)
    HolidayConfigEntity merge(@MappingTarget HolidayConfigEntity entity, HolidayConfig dto);

}
