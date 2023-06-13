package com.example.react.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/api/v1/hello")
    public String test1(){
        return "Hello world!!!!!!!";
    }


}
