package com.doctor.doctor.controller;

import com.doctor.doctor.dto.HolidayConfig;
import com.doctor.doctor.service.HolidayConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/holiday_config")
@Tag(name = "holidayConfig", description = "Holiday config operations")
public class HolidayConfigController {

    private final HolidayConfigService holidayConfigService;

    public HolidayConfigController(HolidayConfigService holidayConfigService) {
        this.holidayConfigService = holidayConfigService;
    }

    @PostMapping
    @Operation(summary = "Create holiday config")
    public HolidayConfig create(@RequestBody HolidayConfig holidayConfig) {
        return holidayConfigService.create(holidayConfig);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update holiday config")
    public HolidayConfig update(@PathVariable String id, @RequestBody HolidayConfig holidayConfig) {
        return holidayConfigService.update(id, holidayConfig);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get holiday config by id")
    public HolidayConfig getHolidayConfigById(@PathParam("id") String id) {
        return holidayConfigService.getById(id);
    }

    @GetMapping("/global-holidays")
    @Operation(summary = "Get global holiday configs")
    public List<HolidayConfig> getHolidayConfigById() {
        return holidayConfigService.findGlobalHolidays();
    }

    @GetMapping("/doctor/{doctorId}")
    @Operation(summary = "Get list of holiday config by doctorId")
    public List<HolidayConfig> getHolidayConfigsByDoctorId(@PathParam("doctorId") String doctorId) {
        return holidayConfigService.getByDoctorId(doctorId);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete holiday config by id")
    public void deleteById(@PathVariable String id) {
        holidayConfigService.delete(id);
    }

}
