package com.doctor.doctor.controller;

import com.doctor.doctor.dto.Tooth;
import com.doctor.doctor.request.ToothUpdateRequest;
import com.doctor.doctor.service.ToothService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tooth")
@Tag(name = "tooth", description = "Tooth operations")
public class ToothController {

    private final ToothService toothService;

    public ToothController(ToothService toothService) {
        this.toothService = toothService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find tooth by id")
    public Tooth findById(@PathVariable String id) {
        return toothService.findById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update tooth")
    public Tooth update(@PathVariable String id, @RequestBody ToothUpdateRequest request) {
        return toothService.update(id, request.getToothState(), request.getComment());
    }

}
