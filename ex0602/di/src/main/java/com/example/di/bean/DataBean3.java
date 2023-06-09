package com.example.di.bean;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString(includeFieldNames = false)
public class DataBean3 {
    private String data1 = "aaa";
    private String data2 = "bbb";
}
