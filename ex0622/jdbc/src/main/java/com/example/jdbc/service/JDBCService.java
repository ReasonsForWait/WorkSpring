package com.example.jdbc.service;

import com.example.jdbc.dao.jdbcDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class JDBCService {
    private final jdbcDAO dao;

    public void getJdbcList(Model model){
        model.addAttribute("list", dao.selectDataList());
    }
}
