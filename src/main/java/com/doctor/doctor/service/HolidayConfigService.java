package com.doctor.doctor.service;

import com.doctor.doctor.dto.HolidayConfig;
import com.doctor.doctor.entity.HolidayConfigEntity;
import com.doctor.doctor.exception.NotFoundException;
import com.doctor.doctor.mapper.HolidayConfigMapper;
import com.doctor.doctor.repository.HolidayConfigRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidayConfigService {

    private final HolidayConfigRepository repository;

    public HolidayConfigService(HolidayConfigRepository repository) {
        this.repository = repository;
    }

    public HolidayConfig create(HolidayConfig holidayConfig) {
        HolidayConfigEntity entity = repository.save(HolidayConfigMapper.INSTANCE.toEntity(holidayConfig));

        return HolidayConfigMapper.INSTANCE.toDto(entity);
    }

    public HolidayConfig update(String id, HolidayConfig holidayConfig) {
        HolidayConfigEntity entity = findEntityById(id);

        HolidayConfigEntity holidayConfigEntity = HolidayConfigMapper.INSTANCE.merge(entity, holidayConfig);

        return HolidayConfigMapper.INSTANCE.toDto(repository.save(holidayConfigEntity));
    }

    public HolidayConfig getById(String id) {
        HolidayConfigEntity entity = findEntityById(id);

        return HolidayConfigMapper.INSTANCE.toDto(entity);
    }

    public List<HolidayConfig> findGlobalHolidays() {
        return repository.findHolidayConfigsByGlobalIsTrue().stream().map(HolidayConfigMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public List<HolidayConfig> getByDoctorId(String doctorId) {
        return repository.findHolidayConfigsByDoctorId(doctorId).stream().map(HolidayConfigMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    private HolidayConfigEntity findEntityById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Holliday config not found by id = %s", id)));
    }

}
