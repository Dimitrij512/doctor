package com.doctor.doctor.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AppointmentRequest {

    private String title;
    private boolean allDay;
    private Date start;
    private Date end;
    private String doctorId;
    private String patientId;
}
