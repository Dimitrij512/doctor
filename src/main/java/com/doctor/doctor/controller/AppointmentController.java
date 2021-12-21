package com.doctor.doctor.controller;

import com.doctor.doctor.dto.Appointment;
import com.doctor.doctor.request.AppointmentRequest;
import com.doctor.doctor.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/appointment")
@Tag(name = "appointment", description = "Appointment operations")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find appointment")
    public Appointment getById(@PathVariable String id) {
        return appointmentService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Create appointment")
    public Appointment create(@RequestBody AppointmentRequest request) {
        return appointmentService.create(request);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update appointment")
    public Appointment update(@PathVariable String id, @RequestBody AppointmentRequest request) {
        return appointmentService.update(id, request);
    }

    @GetMapping("/{dateFrom}/{dateTo}")
    @Operation(summary = "Find appointments by dates")
    public List<Appointment> getAllByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo) {
        return appointmentService.getAllByDate(dateFrom, dateTo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete appointment")
    public void delete(@PathVariable String id) {
        appointmentService.delete(id);
    }
}
