package com.example.jsp1.controller;

import com.example.jsp1.dto.UserDataDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example04")
public class Example04Controller {
    @GetMapping("/test1")
    public String test1(UserDataDTO dto){
        dto.setUsername("이건주");
        dto.setUserid("leekjgo21");
        dto.setUserpw("leerjswn21##");
        dto.setUserPostcode("0222");
        dto.setUserAddress1("인천");
        dto.setUserAddress2("남동구");
        return "example04/test1";
    }
}
