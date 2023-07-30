package com.example.paymentTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PaymentController {
    @PostMapping("/payment")
    public String paymentSuccess(){
        return "success";
    }
}
