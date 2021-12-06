package com.doctor.doctor.controller;

import com.doctor.doctor.dto.MedicalCard;
import com.doctor.doctor.request.DoctorNoteRequest;
import com.doctor.doctor.service.MedicalCardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical_card")
@Tag(name = "medicalCard", description = "Medical card operations")
public class MedicalCardController {

    private final MedicalCardService medicalCardService;

    public MedicalCardController(MedicalCardService medicalCardService) {
        this.medicalCardService = medicalCardService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find medicalCard by id")
    public MedicalCard findById(@PathVariable String id) {
        return medicalCardService.findById(id);
    }

    @GetMapping("/patient/{patientId}")
    @Operation(summary = "Find medicalCards by patientId")
    public MedicalCard findByPatientId(@PathVariable String patientId) {
        return medicalCardService.findByPatientId(patientId);
    }

    @GetMapping("/doctor/{doctorId}")
    @Operation(summary = "Find medicalCards by doctorId")
    public List<MedicalCard> findAllByDoctorId(@PathVariable String doctorId) {
        return medicalCardService.findAllByDoctorId(doctorId);
    }

    @PutMapping("{id}/doctor_note")
    @Operation(summary = "Add doctorNote to medicalCard")
    public void addDoctorNote(@PathVariable String id, @RequestBody DoctorNoteRequest doctorNoteRequest) {
        medicalCardService.addDoctorNote(id, doctorNoteRequest);
    }

    @PutMapping("{id}/doctor/{doctorId}")
    @Operation(summary = "Update doctorId")
    public void addDoctorId(@PathVariable String id, @PathVariable String doctorId) {
        medicalCardService.updateDoctorId(id, doctorId);
    }

}
