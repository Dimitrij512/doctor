package com.doctor.doctor.service;

import com.doctor.doctor.dto.Doctor;
import com.doctor.doctor.entity.DoctorEntity;
import com.doctor.doctor.exception.NotFoundException;
import com.doctor.doctor.mapper.DoctorMapper;
import com.doctor.doctor.repository.DoctorRepository;
import com.doctor.doctor.request.DoctorRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor create(DoctorRequest doctorRequest) {
        DoctorEntity entity = doctorRepository.save(DoctorMapper.INSTANCE.toEntity(doctorRequest));
        return DoctorMapper.INSTANCE.toDto(entity);
    }

    public Doctor update(String doctorId, DoctorRequest doctorRequest) {
        DoctorEntity doctorEntity = findEntityById(doctorId);

        DoctorEntity doctorEntityUpdated = doctorRepository
                .save(DoctorMapper.INSTANCE.merge(doctorEntity, doctorRequest));

        return DoctorMapper.INSTANCE.toDto(doctorEntityUpdated);
    }

    public Doctor findById(String id) {
        DoctorEntity entity = findEntityById(id);

        return DoctorMapper.INSTANCE.toDto(entity);
    }

    public boolean notExistById(String id) {
        return !doctorRepository.existsById(id);
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll().stream().map(DoctorMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    private DoctorEntity findEntityById(String id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Not found doctor by id = %s", id)));
    }

}
