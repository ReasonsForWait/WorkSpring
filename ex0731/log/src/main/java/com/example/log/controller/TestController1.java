package com.example.log.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TestController1 {

    // 로그를 사용하기 위한 기본적인 선언
//    final Logger log = LoggerFactory.getLogger(TestController1.class);

    @GetMapping("/log1")
    public String log1(){
//        System.out.println("log1 실행 확인");
        // 가장 낮은레벨의 로그, 디테일한 정보를 보이고 싶을 때 사용하는 로그
        log.trace("trace 메시지");
        // 그다음 레벨 로그, 디버그를 위한 로그정보를 보이고 싶을 때 사용하는 로그
        log.debug("debug 메시지");
        // 중간 레벨, 일반 정보를 출력할 경우 사용하는 로그
        log.info("info 메시지");
        // 경고 레벨, 정상적인 로직이지만 경고를 알람할 경우 쓸 수 있는 레벨
        log.warn("warn 메시지");
        // 위험 레벨, 비정상적인 500에러가 발생했을 경우 쓸 수 있는 레벨
        log.error("error 메시지");

        return "redirect:/";
    }

    @GetMapping("/log2")
    public String log2(){
        String data1 = "데이타1";
        String data2 = "데이타2";
        String data3 = "데이타3";

        log.debug("data1 = {}",data1);
        log.info("data1 = {}, data2 = {}",data1,data2);
        log.warn("data1 = {}, data2 = {}, data3 = {}",data1,data2,data3);

        return "redirect:/";
    }
}
