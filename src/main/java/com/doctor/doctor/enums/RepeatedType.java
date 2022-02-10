package com.doctor.doctor.enums;

import lombok.Getter;

public enum RepeatedType {
    DAILY(1), WEEKLY(7), NEVER(0);

    @Getter
    private final Integer count;

    RepeatedType(Integer count) {
        this.count = count;
    }
}
