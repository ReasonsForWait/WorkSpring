package com.example.springmvc1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Servlet을 나타내는 컨트롤러 클래스 표시
// 요청과 응답만을 받아 처리하는 개체를 가리킬 때 사용하는 어노테이션
@Controller
public class HomeController {

    // Servlet 클래스에서의 doGet, doPost 같은 역할을 하는 메서드를 지칭할 때 쓰는
    // 어노테이션, url 경로, method가 여기 들어간다.
    // - root 경로를 Get으로 호출했을 시 요청되는 메서드
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }
}
