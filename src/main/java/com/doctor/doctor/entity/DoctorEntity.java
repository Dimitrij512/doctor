package com.doctor.doctor.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorEntity extends BaseEntity {

    private String name;
    private String sureName;
    private String phone;
}
