package com.doctor.doctor.entity;

import com.doctor.doctor.enums.HolidayType;
import com.doctor.doctor.enums.RepeatedType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class HolidayConfigEntity extends BaseEntity {

    private String doctorId;
    private String title;
    private HolidayType type;
    private RepeatedType repeatedType;
    private boolean global;
    private Date start;
    private Date end;
}
