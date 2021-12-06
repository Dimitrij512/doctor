package com.doctor.doctor.controller;

import com.doctor.doctor.dto.MedicalCard;
import com.doctor.doctor.request.DoctorNoteRequest;
import com.doctor.doctor.service.MedicalCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical_card")
public class MedicalCardController {

    private final MedicalCardService medicalCardService;

    public MedicalCardController(MedicalCardService medicalCardService) {
        this.medicalCardService = medicalCardService;
    }

    @GetMapping("/{id}")
    public MedicalCard findById(@PathVariable String id) {
        return medicalCardService.findById(id);
    }

    @GetMapping("/patient/{patientId}")
    public MedicalCard findByPatientId(@PathVariable String patientId) {
        return medicalCardService.findByPatientId(patientId);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<MedicalCard> findAllByDoctorId(@PathVariable String doctorId) {
        return medicalCardService.findAllByDoctorId(doctorId);
    }

    @PutMapping("{id}/doctor_note")
    public void addDoctorNote(@PathVariable String id, @RequestBody DoctorNoteRequest doctorNoteRequest) {
        medicalCardService.addDoctorNote(id, doctorNoteRequest);
    }

    @PutMapping("{id}/doctor/{doctorId}")
    public void addDoctorId(@PathVariable String id, @PathVariable String doctorId) {
        medicalCardService.updateDoctorId(id, doctorId);
    }

}
