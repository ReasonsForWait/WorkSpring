package com.example.mybatis.controller;

import com.example.mybatis.dto.EmpDTO;
import com.example.mybatis.dto.EmpDTO2;
import com.example.mybatis.service.MVCService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/param")
public class SecondController {

    private final MVCService service;

    @GetMapping("input1")
    public String input1(){
        return "param/input1";
    }

    @GetMapping("result1")
    public String result1(
            Model model,
            @RequestParam("id") int id){
        service.getItemListWithParam1(model, id);
        return "param/result1";
    }

    @GetMapping("input2")
    public String input2(){
        return "param/input2";
    }

    @GetMapping("result2")
    public String result2(
            Model model,
            @RequestParam("deptno") int deptno,
            @RequestParam("job") String job){
        service.getItemListWithParam2(model, deptno, job);
        return "param/result2";
    }

    @GetMapping("input3")
    public String input3(Model model, EmpDTO2 dto){
        model.addAttribute("dto", dto);
        return "param/input3";
    }

    @GetMapping("result3")
    public String result3(
            Model model,
            EmpDTO2 dto){
        service.getItemListWithParam3(model, dto);
        return "param/result3";
    }
}
