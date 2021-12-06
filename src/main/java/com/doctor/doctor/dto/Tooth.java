package com.doctor.doctor.dto;

import com.doctor.doctor.enums.ToothNumberEnum;
import com.doctor.doctor.enums.ToothPositionEnum;
import com.doctor.doctor.enums.ToothState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tooth {

    String id;
    String medicalCardId;
    ToothNumberEnum toothNumber;
    ToothPositionEnum position;
    ToothState toothState;
    String comment;
}
