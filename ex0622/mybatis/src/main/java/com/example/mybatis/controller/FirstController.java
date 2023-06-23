package com.example.mybatis.controller;

import com.example.mybatis.service.MVCService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class FirstController {

    private final MVCService service;

    @GetMapping("get-cnt")
    public String getCnt(Model model){
        service.getCount(model);
        return "mvc/result1";
    }

    @GetMapping("get-ename")
    public String getEname(Model model){
        service.getEname(model);
        return "mvc/result2";
    }

    @GetMapping("get-item1")
    public String getItem1(Model model){
        service.getItem1(model);
        return "mvc/result3";
    }

    @GetMapping("get-item2")
    public String getItem2(Model model){
        service.getItem2(model);
        return "mvc/result4";
    }
}
