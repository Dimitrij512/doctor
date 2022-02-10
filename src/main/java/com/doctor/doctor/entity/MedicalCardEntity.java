package com.doctor.doctor.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MedicalCardEntity extends BaseEntity {

    private String patientId;
    private String doctorId;
    private List<DoctorNote> doctorNotes = new ArrayList<>();
}
