package com.doctor.doctor.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Getter
@Setter
public class DoctorNote {

    @Id
    String id;
    String doctorId;
    String patientId;
    String note;
    Instant createdDate;
    Instant updatedDate;
}
