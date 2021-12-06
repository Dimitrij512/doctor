package com.doctor.doctor.entity;

import com.doctor.doctor.enums.ToothNumberEnum;
import com.doctor.doctor.enums.ToothPositionEnum;
import com.doctor.doctor.enums.ToothState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToothEntity extends BaseEntity {

    String medicalCardId;
    ToothNumberEnum toothNumber;
    ToothPositionEnum position;
    ToothState toothState;
    String comment;
}
