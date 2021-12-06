package com.doctor.doctor.entity;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter
@Setter
public class DoctorNote {

    String id;
    String doctorId;
    String note;
    DateTime createdDate = DateTime.now();
}
