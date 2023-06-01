package com.example.thymeleaf.controller;

import com.example.thymeleaf.beans.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/loginPage")
    public String loginPage(){
        return "login/loginPage";
    }

    @PostMapping("/resultPage")
    public String resultPage(@ModelAttribute UserInfo info, Model model){
        model.addAttribute("userInfo", info);
        return "login/resultPage";
    }
}
