package com.example.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/basic")
public class BasicController {
    @GetMapping("/text-basic")
    public String textBasic(Model model){
        model.addAttribute("data1", "hello spring!");
        model.addAttribute("data2", "hello <b>spring!</b>");

        return "basic/text01";
    }

    @GetMapping("/date")
    public String date(Model model){
        model.addAttribute("LocalDateTime", LocalDateTime.now());
        return "basic/date";
    }
}
