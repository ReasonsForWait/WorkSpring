package com.example.paymentTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class UserController {
    @GetMapping("paymentPage")
    public String paymentPage(@RequestParam("product") String product,
                              @RequestParam("name") String name,
                              @RequestParam("price") Integer price,
                              Model mo){
        mo.addAttribute("product", product);
        mo.addAttribute("name", name);
        mo.addAttribute("price", price);
        return "paymentPage";
    }
}
