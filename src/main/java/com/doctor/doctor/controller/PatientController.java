package com.doctor.doctor.controller;

import com.doctor.doctor.entity.Patient;
import com.doctor.doctor.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public Patient save(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @GetMapping("/{id}")
    public Patient findById(@PathVariable String id) {
        return patientService.findById(id);
    }

    @GetMapping("/all")
    public List<Patient> findAll() {
        return patientService.findAll();
    }
}
