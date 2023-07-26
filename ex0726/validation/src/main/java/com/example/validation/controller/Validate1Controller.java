package com.example.validation.controller;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/valid1")
@Validated
public class Validate1Controller {

    @PostMapping("/req1")
    public String request1(@RequestParam("text1") @Size(min = 3, max=10) String text1,
                           @RequestParam("text2") @Size(min = 1, max=5) String text2){
        System.out.println("text1 : "+text1);
        System.out.println("text2 : "+text2);
        return "redirect:/";
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public String exception1(ConstraintViolationException e1){
        System.out.println("해당 에러 발생");

        System.out.println(e1.getCause());
        System.out.println(e1.getMessage());
        return "/error1";
    }
}
