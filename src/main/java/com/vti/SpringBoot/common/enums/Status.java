package com.vti.SpringBoot.common.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum Status {
    OPEN("O"), Review("Rew"), APPROVED("A"), REJECTED("R");


    private String status;

    Status(String status) {
    }

    public static Status toEnum(String status) {
        for (Status item : Status.values()) {
            if (item.getStatus().equals(status)) {
                return item;
            }
        }
        return null;
    }

}
