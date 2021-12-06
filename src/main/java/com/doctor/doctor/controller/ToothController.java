package com.doctor.doctor.controller;

import com.doctor.doctor.dto.Tooth;
import com.doctor.doctor.request.ToothUpdateRequest;
import com.doctor.doctor.service.ToothService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tooth")
public class ToothController {

    private final ToothService toothService;

    public ToothController(ToothService toothService) {
        this.toothService = toothService;
    }

    @GetMapping("/{id}")
    public Tooth findById(@PathVariable String id) {
        return toothService.findById(id);
    }

    @PutMapping("/{id}")
    public Tooth update(@PathVariable String id, @RequestBody ToothUpdateRequest request) {
        return toothService.update(id, request.getToothState(), request.getComment());
    }

}
