package com.example.react.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class CorsController {
    @GetMapping("/non-cors")
    public String nonCors(){
        System.out.println("non-cors");
        return "not Cors";
    }
    @CrossOrigin("http://localhost:3000")
    @GetMapping("/cors")
    public String Cors(){
        System.out.println("cors");
        return "Cors";
    }

    @GetMapping("/non-proxy")
    public String nonProxy(){
        System.out.println("non-proxy");
        return "not proxy";
    }

    @GetMapping("/proxy")
    public String proxy(){
        System.out.println("proxy");
        return "proxy";
    }
}
