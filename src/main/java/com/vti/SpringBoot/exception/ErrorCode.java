package com.vti.SpringBoot.exception;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    UNCATEGORIZED(9999, "Uncategorized"),
    USER_EXISTED(1001, "user existed"),
    USERNAME_INVALID(1003, "User must be at least 3"),
    USER_NOT_EXISTED(1002, "USER NOT EXISTED");
    int code;
    String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
