package com.example.mybatis.controller;

import com.example.mybatis.service.MVCService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc")
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

    @GetMapping("get-list1")
    public String getList1(Model model){
        service.getItemList1(model);
        return "mvc/result4";
    }

    @GetMapping("get-list2")
    public String getList2(Model model){
        service.getItemList2(model);
        return "mvc/result5";
    }
}
