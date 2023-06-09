package com.example.di.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
@AllArgsConstructor // 모든 필드를 담은 생성자를 생성할 경우 사용
@NoArgsConstructor // 빈 생성자를 생성할 경우 사용
public class DataBean4 {
    private String data1;
    private String data2;
}
