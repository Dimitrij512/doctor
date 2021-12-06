package com.doctor.doctor.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientEntity extends BaseEntity {

    String medicalCardId;
    String doctorId;
    String name;
    String sureName;
    String phone;
}
