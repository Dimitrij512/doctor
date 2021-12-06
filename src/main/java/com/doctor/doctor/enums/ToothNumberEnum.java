package com.doctor.doctor.enums;

import lombok.Getter;

public enum ToothNumberEnum {
    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5), SIXTH(6), SEVENTH(7), EIGHTH(8);

    @Getter
    private final Integer number;

    ToothNumberEnum(Integer number) {
        this.number = number;
    }
}
