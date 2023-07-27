package com.example.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/weak")
public class WeakController {

    @GetMapping("/form")
    public String weakForm(){
        return "/weakform";
    }

    @PostMapping("/send")
    public String send(@RequestParam("text1") String text1,
                       @RequestParam("text2") String text2){
        System.out.println("text1 : "+text1);
        System.out.println("text2 : "+text2);
        return "redirect:/";
    }
}
