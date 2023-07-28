package com.example.validation.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message")
public class MessageControlller {

    @Value("${aaa.a1}")
    private Integer a1;

    @Value("${aaa.a2}")
    private String a2;

    @Value("${bbb.b1}")
    private Integer b1;

    @Value("${bbb.b2}")
    private String b2;

    @GetMapping("/output1")
    public String output1(){

        System.out.println("a1 : "+a1);
        System.out.println("a2 : "+a2);
        System.out.println("b1 : "+b1);
        System.out.println("b2 : "+b2);

        return "redirect:/";
    }
}
