package com.example.jsp1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/test8_1")
    public String test81(RedirectAttributes attr){
        attr.addAttribute("path1","path1");
        attr.addAttribute("data1","가나다");
        return "redirect:/example03/test3/{path1}";
    }

    @GetMapping("/test3/{path}")
    public String test82(@PathVariable("path") String path,
                         @RequestParam String data1){
        System.out.println("path : " + path);
        System.out.println("data1 : " + data1);
        return "example03/index";
    }
}
