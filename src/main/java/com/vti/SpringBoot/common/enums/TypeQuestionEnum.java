package com.vti.SpringBoot.common.enums;

public enum TypeQuestionEnum {
    Essay("E"), Muntiple_Choise("M");
    private String type;

    private TypeQuestionEnum(String type) {
        this.type = type;
    }
}
