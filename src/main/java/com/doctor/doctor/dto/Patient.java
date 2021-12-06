package com.doctor.doctor.dto;

import lombok.Data;

@Data
public class Patient {

    String id;
    String doctorId;
    String name;
    String sureName;
    String phone;
}
