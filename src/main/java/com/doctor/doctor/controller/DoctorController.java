package com.doctor.doctor.controller;

import com.doctor.doctor.dto.Doctor;
import com.doctor.doctor.request.DoctorRequest;
import com.doctor.doctor.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@Tag(name = "doctor", description = "Doctor operations")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    @Operation(summary = "Create doctor account")
    public Doctor create(@RequestBody DoctorRequest doctorRequest) {
        return doctorService.create(doctorRequest);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update doctor account")
    public Doctor update(@PathVariable String id, @RequestBody DoctorRequest doctorRequest) {
        return doctorService.update(id, doctorRequest);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find doctor account by id")
    public Doctor findById(@PathVariable String id) {
        return doctorService.findById(id);
    }

    @GetMapping("/all")
    @Operation(summary = "Find all doctor accounts")
    public List<Doctor> findAll() {
        return doctorService.findAll();
    }
}
