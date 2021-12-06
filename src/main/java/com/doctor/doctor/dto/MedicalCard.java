package com.doctor.doctor.dto;

import com.doctor.doctor.entity.DoctorNote;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MedicalCard {

    String id;
    String patientId;
    String doctorId;
    List<Tooth> toothList;
    List<DoctorNote> doctorNotes = new ArrayList<>();
}
