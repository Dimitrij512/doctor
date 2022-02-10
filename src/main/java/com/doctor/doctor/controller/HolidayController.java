package com.doctor.doctor.controller;

import com.doctor.doctor.dto.Holiday;
import com.doctor.doctor.service.HolidayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/holiday")
@Tag(name = "holiday", description = "Holiday operations")
public class HolidayController {

    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping("/{doctorId}/{dateFrom}/{dateTo}")
    @Operation(summary = "Get holidays by doctor id and range of date")
    public List<Holiday> getHolidays(@PathParam("doctorId") String doctorId,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo) {
        return holidayService.getHolidays(doctorId, dateFrom, dateTo);
    }

    @GetMapping("/global_holidays")
    @Operation(summary = "Get global holidays for all company")
    public List<Holiday> getHolidays() {
        return holidayService.getGlobalHolidays();
    }
}
