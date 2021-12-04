package com.doctor.doctor.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class DentalCard {

    String id;
    List<String> toothIds;
    Instant createdDate;
    Instant updatedDate;
}
