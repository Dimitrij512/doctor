package com.doctor.doctor.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorNoteRequest {
    String doctorId;
    String note;
}
