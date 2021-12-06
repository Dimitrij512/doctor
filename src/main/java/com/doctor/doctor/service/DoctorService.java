package com.doctor.doctor.service;

import com.doctor.doctor.dto.Doctor;
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

    public Doctor save(DoctorRequest doctorRequest) {
        var entity = doctorRepository.save(DoctorMapper.INSTANCE.toEntity(doctorRequest));
        return DoctorMapper.INSTANCE.toDto(entity);
    }

    public Doctor findById(String id) {
        var entity = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Not found doctor by id = %s", id)));

        return DoctorMapper.INSTANCE.toDto(entity);
    }

    public boolean notExistById(String id) {
        return !doctorRepository.existsById(id);
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll().stream().map(DoctorMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

}
