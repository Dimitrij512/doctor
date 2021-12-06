package com.doctor.doctor.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorEntity extends BaseEntity {

    String name;
    String sureName;
    String phone;
}
