package com.doctor.doctor.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class DentalCard {

    @Id
    String id;
    String medicalCardId;
    List<String> toothIds;
    Instant createdDate;
    Instant updatedDate;
}
