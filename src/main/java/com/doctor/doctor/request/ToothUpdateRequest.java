package com.doctor.doctor.request;

import com.doctor.doctor.enums.ToothState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToothUpdateRequest {

    ToothState toothState;
    String comment;
}
