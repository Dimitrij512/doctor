package com.doctor.doctor.dto;

import com.doctor.doctor.enums.HolidayType;
import com.doctor.doctor.enums.RepeatedType;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import java.util.Date;

@Data
public class HolidayConfig {

    private String id;
    private String doctorId;
    private String title;
    private HolidayType type;
    private RepeatedType repeatedType;
    private boolean global;
    private Date start;
    private Date end;
}
