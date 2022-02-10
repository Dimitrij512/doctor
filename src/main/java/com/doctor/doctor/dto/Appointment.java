package com.doctor.doctor.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Appointment {

    private String id;
    private String doctorId;
    private Patient patient;
    private String title;
    private boolean allDay;
    private Date start;
    private Date end;
}
