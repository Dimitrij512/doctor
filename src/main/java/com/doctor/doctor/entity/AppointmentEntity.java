package com.doctor.doctor.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AppointmentEntity extends BaseEntity {

    private String doctorId;
    private String patientId;
    private String title;
    private boolean allDay;
    private Date start;
    private Date end;
}
