package com.doctor.doctor.service;

import com.doctor.doctor.entity.Doctor;
import com.doctor.doctor.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor findById(String id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

}
