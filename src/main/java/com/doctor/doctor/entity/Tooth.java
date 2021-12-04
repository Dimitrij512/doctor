package com.doctor.doctor.entity;

import com.doctor.doctor.enums.ToothNumberEnum;
import com.doctor.doctor.enums.ToothPositionEnum;
import com.doctor.doctor.enums.ToothState;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Getter
@Setter
public class Tooth {

    @Id
    String id;
    String dentalCardId;
    ToothNumberEnum toothNumber;
    ToothPositionEnum position;
    ToothState toothState;
    String comment;
    Instant createdDate;
    Instant updatedDate;
}
