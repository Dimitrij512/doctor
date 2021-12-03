package com.doctor.doctor.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Getter
@Setter
public class Doctor {

    @Id
    String id;
    String name;
    String sureName;
    String phone;
    Instant createdDate;
    Instant updatedDate;
}
