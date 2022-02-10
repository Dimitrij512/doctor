package com.doctor.doctor.service;

import com.doctor.doctor.dto.Holiday;
import com.doctor.doctor.dto.HolidayConfig;
import com.doctor.doctor.enums.RepeatedType;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidayService {

    private final HolidayConfigService holidayConfigService;

    public HolidayService(HolidayConfigService holidayConfigService) {
        this.holidayConfigService = holidayConfigService;
    }

    public List<Holiday> getGlobalHolidays() {
        return holidayConfigService
                .findGlobalHolidays().stream().map(config -> Holiday.builder().title(config.getTitle())
                        .type(config.getType()).start(config.getStart()).end(config.getEnd()).build())
                .collect(Collectors.toList());
    }

    public List<Holiday> getHolidays(String doctorId, Date startDay, Date endDate) {

        List<HolidayConfig> holidayConfigs = holidayConfigService.getByDoctorId(doctorId);

        return holidayConfigs.stream().map(c -> generateHolidays(c, startDay, endDate)).flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    List<Holiday> generateHolidays(HolidayConfig holidayConfig, Date startDay, Date endDate) {

        List<Holiday> holidays = new ArrayList<>();

        if (holidayConfig.getRepeatedType() == RepeatedType.NEVER) {

            if (holidayConfig.getEnd().after(startDay)) {
                holidays.add(Holiday.builder().doctorId(holidayConfig.getDoctorId()).title(holidayConfig.getTitle())
                        .type(holidayConfig.getType()).start(holidayConfig.getStart()).end(holidayConfig.getEnd())
                        .build());
            }

            return holidays;
        }

        Date start = new Date(startDay.getYear(), startDay.getMonth(), startDay.getDay(),
                holidayConfig.getStart().getHours(), holidayConfig.getStart().getMinutes());
        Date end = new Date(startDay.getYear(), startDay.getMonth(), startDay.getDay(),
                holidayConfig.getEnd().getHours(), holidayConfig.getEnd().getMinutes());

        while (end.before(endDate)) {

            if (!isWeekend(start)) {
                Holiday holiday = Holiday.builder().doctorId(holidayConfig.getDoctorId())
                        .title(holidayConfig.getTitle()).type(holidayConfig.getType()).start(start).end(end).build();

                holidays.add(holiday);
            }

            start = new Date(
                    start.toInstant().plus(holidayConfig.getRepeatedType().getCount(), ChronoUnit.DAYS).toEpochMilli());
            end = new Date(
                    end.toInstant().plus(holidayConfig.getRepeatedType().getCount(), ChronoUnit.DAYS).toEpochMilli());
        }

        return holidays;
    }

    private boolean isWeekend(Date date) {
        return date.getDate() == 7 || date.getTime() == 1;
    }
}
