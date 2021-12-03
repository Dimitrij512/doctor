package com.doctor.doctor.enums;

import lombok.Getter;

public enum ToothState {
    CARIES("C"),
    PULPITS("P"),
    PERIODONTITIS("Pt"),
    SEAL("П"),
    MISSING("O"),
    CROWN("К"),
    ROOT("R");

    @Getter
    private final String stateName;

    ToothState(String stateName) {
        this.stateName = stateName;
    }
}
