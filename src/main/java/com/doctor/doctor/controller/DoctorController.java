package com.doctor.doctor.controller;

import com.doctor.doctor.entity.Doctor;
import com.doctor.doctor.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/")
    public Doctor save(@RequestBody Doctor patient) {
        return doctorService.save(patient);
    }

    @GetMapping("/{id}")
    public Doctor findById(@PathVariable String id) {
        return doctorService.findById(id);
    }

    @GetMapping("/all")
    public List<Doctor> findAll() {
        return doctorService.findAll();
    }
}
