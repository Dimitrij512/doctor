package com.doctor.doctor.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequest {

    String doctorId;
    String name;
    String sureName;
    String phone;
}
