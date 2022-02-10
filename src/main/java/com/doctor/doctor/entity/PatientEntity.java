package com.doctor.doctor.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientEntity extends BaseEntity {

    private String medicalCardId;
    private String doctorId;
    private String name;
    private String sureName;
    private String phone;
}
