package com.doctor.doctor.service;

import com.doctor.doctor.dto.Tooth;
import com.doctor.doctor.entity.ToothEntity;
import com.doctor.doctor.enums.ToothState;
import com.doctor.doctor.exception.NotFoundException;
import com.doctor.doctor.mapper.ToothMapper;
import com.doctor.doctor.repository.ToothRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToothService {
    private final ToothRepository toothRepository;

    public ToothService(ToothRepository toothRepository) {
        this.toothRepository = toothRepository;
    }

    public Tooth update(String toothId, ToothState toothState, String comment) {

        Tooth tooth = findById(toothId);
        tooth.setToothState(toothState);
        tooth.setComment(comment);

        ToothEntity entity = toothRepository.save(ToothMapper.INSTANCE.toEntity(tooth));

        return ToothMapper.INSTANCE.toDto(entity);
    }

    public Tooth findById(String toothId) {
        ToothEntity entity = toothRepository.findById(toothId)
                .orElseThrow(() -> new NotFoundException(String.format("Not found tooth by id= %s", toothId)));
        return ToothMapper.INSTANCE.toDto(entity);
    }

    public List<Tooth> findAllByByMedicalCardId(String medicalCardId) {
        return toothRepository.findAllByMedicalCardId(medicalCardId).stream().map(ToothMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
