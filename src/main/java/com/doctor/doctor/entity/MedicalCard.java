package com.doctor.doctor.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class MedicalCard {

    String id;
    String patientId;
    String doctorId;
    String dentalCardId;
    List<String> doctorNoteIds;
    Instant createdDate;
    Instant updatedDate;
}
