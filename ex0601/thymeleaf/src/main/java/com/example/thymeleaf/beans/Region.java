package com.example.thymeleaf.beans;

public enum Region {
    SEOUL("서울"), BUSAN("부산"), JEJU("제주");

    private final String desc;

    Region(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
