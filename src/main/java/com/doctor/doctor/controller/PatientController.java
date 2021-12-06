package com.doctor.doctor.controller;

import com.doctor.doctor.dto.Patient;
import com.doctor.doctor.request.PatientRequest;
import com.doctor.doctor.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@Tag(name = "patient", description = "Patient operations")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    @Operation(summary = "Create patient account")
    public Patient create(@RequestBody PatientRequest patientCreateRequest) {
        return patientService.create(patientCreateRequest);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update patient account")
    public Patient update(@PathVariable String id, @RequestBody PatientRequest patientCreateRequest) {
        return patientService.update(id, patientCreateRequest);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find patient account by id")
    public Patient findById(@PathVariable String id) {
        return patientService.findById(id);
    }

    @GetMapping("/doctor/{doctorId}")
    @Operation(summary = "Find all patients by doctorId")
    public List<Patient> findAllByDoctorId(@PathVariable String doctorId) {
        return patientService.findAllByDoctorId(doctorId);
    }

    @GetMapping("/all")
    @Operation(summary = "Find all patients")
    public List<Patient> findAll() {
        return patientService.findAll();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete patient by id")
    public void deleteById(@PathVariable String id) {
        patientService.deleteById(id);
    }
}
