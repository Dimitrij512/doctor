package com.doctor.doctor.dto;

import com.doctor.doctor.enums.HolidayType;
import lombok.Builder;

import java.util.Date;

@Builder
public class Holiday {

    private final String doctorId;
    private final String title;
    private final HolidayType type;
    private final Date start;
    private final Date end;
}
