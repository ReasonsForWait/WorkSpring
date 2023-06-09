package com.example.di.bean;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class DataBean2 {
    @Getter
    private String data1 = "123";
    @Setter
    private String data2;
    @Getter(AccessLevel.PROTECTED)
    private String data3;
}
