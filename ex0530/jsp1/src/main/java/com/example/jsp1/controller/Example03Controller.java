package com.example.jsp1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example03")
public class Example03Controller {

    @PostMapping("/test2")
    public String test2(){
        return "example03/test2";
    }

    @GetMapping("/test3")
    public String test3(){
        return "example03/test3";
    }
}
