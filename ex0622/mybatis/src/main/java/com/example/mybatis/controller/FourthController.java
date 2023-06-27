package com.example.mybatis.controller;

import com.example.mybatis.dto.DeptDTO1;
import com.example.mybatis.service.MVCService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/modify")
public class FourthController {

    private final MVCService service;

    @GetMapping("input1")
    public String input1(){
        return "modify/input1";
    }
    @GetMapping("result1")
    public String result1(DeptDTO1 dto){
        service.setDept1(dto);
        return "modify/result1";
    }

    @GetMapping("input2")
    public String input2(){
        return "modify/input2";
    }

    @GetMapping("result2")
    public String result2(DeptDTO1 dto){
        service.setDept1(dto);
        return "modify/result2";
    }

    @GetMapping("input3")
    public String input3(Model mo,
                         @RequestParam("deptno") Integer deptno){
        service.getDept1(mo, deptno);
        return "modify/input3";
    }

    @GetMapping("input4")
    public String input4(@RequestParam("deptno") Integer deptno){
        service.deleteDept1(deptno);
        return "modify/result4";
    }
}
