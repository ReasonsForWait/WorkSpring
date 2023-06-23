package com.example.mybatis.service;

import com.example.mybatis.dao.MVCMapper;
import com.example.mybatis.dto.EmpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class MVCService {

    private final MVCMapper dao;

    public void getCount(Model model){
        model.addAttribute("cnt",dao.getCount());
    }

    public void getEname(Model model){
        model.addAttribute("ename",dao.getEname());
    }

    public void getItem1(Model model){
        System.out.println("item1 : "+dao.getItem1());
        model.addAttribute("item1", dao.getItem1());
    }

    public void getItem2(Model model){
        model.addAttribute("list", dao.getItem2());
    }

    public void getItemListParam(Model mo, EmpDTO dto){
        mo.addAttribute("list", dao.getItemListParam(dto));
    }
}
