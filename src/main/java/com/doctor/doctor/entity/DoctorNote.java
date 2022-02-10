package com.doctor.doctor.entity;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter
@Setter
public class DoctorNote {

    private String id;
    private String doctorId;
    private String note;
    private DateTime createdDate = DateTime.now();
}
