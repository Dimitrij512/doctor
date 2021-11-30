package com.doctor.doctor.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Patient {
    @Id
    String id;
    String name;
    String sureName;
    String phone;
}
