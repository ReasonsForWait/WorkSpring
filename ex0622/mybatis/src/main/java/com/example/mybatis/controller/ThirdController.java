package com.example.mybatis.controller;

import com.example.mybatis.dto.EmpDTO2;
import com.example.mybatis.service.MVCService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dynamic")
@RequiredArgsConstructor
public class ThirdController {

    private final MVCService service;

    @GetMapping("input1")
    public String input1(Model model, EmpDTO2 dto){
        model.addAttribute("dto", dto);
        return "dynamic/input1";
    }

    @GetMapping("result1")
    public String result1(
            Model model,
            EmpDTO2 dto){
        service.getItemListWithParam4(model, dto);
        return "dynamic/result1";
    }

    @GetMapping("input2")
    public String input2(Model model, EmpDTO2 dto){
        model.addAttribute("dto", dto);
        return "dynamic/input2";
    }

    @GetMapping("result2")
    public String result2(
            Model model,
            EmpDTO2 dto){
        service.getItemListWithParam5(model, dto);
        return "dynamic/result2";
    }

    @GetMapping("input3")
    public String input3(){
        return "dynamic/input3";
    }

    @GetMapping("result3")
    public String result3(
            Model model,
            @RequestParam("jobs") String[] jobs){
        service.getItemListWithParam6(model, jobs);
        return "dynamic/result3";
    }
}
