package com.example.jdbc.controller;

import com.example.jdbc.service.JDBCService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class jdbcController {
    private final JDBCService service;

    @GetMapping("/getList")
    public String getList(Model model){
        service.getJdbcList(model);
        return "result1";
    }
}
