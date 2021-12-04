package com.doctor.doctor.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MedicalCard {

    @Id
    String id;
    String patientId;
    String doctorId;
    DentalCard dentalCard;
    List<DoctorNote> doctorNotes = new ArrayList<>();
    Instant createdDate;
    Instant updatedDate;
}
