package com.doctor.doctor.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MedicalCardEntity extends BaseEntity {

    String patientId;
    String doctorId;
    List<DoctorNote> doctorNotes = new ArrayList<>();
}
