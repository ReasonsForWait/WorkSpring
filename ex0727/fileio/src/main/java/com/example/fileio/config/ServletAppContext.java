package com.example.fileio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Spring Boot 내에서 설정과 관련된 리소스를 담고 있는 클래스를 선언할 때 사용하는 어노테이션
@Configuration
public class ServletAppContext implements WebMvcConfigurer {

    // 정적 파일의 경로를 설정하는 메서드를 오버라이드해서 사용
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        // 정적 리소스를 추가
        registry.addResourceHandler("/download3/**").addResourceLocations("file:///D:/workspring/data/");
    }
}
