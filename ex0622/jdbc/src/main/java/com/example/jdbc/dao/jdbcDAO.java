package com.example.jdbc.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.jdbc.dto.empDTO;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class jdbcDAO {
    private final JdbcTemplate db;
    private final MapperClass1 mapper1;

    public List<empDTO> selectDataList(){
        String sql = "select empno, ename, sal from emp01";
        List<empDTO> list = db.query(sql, mapper1);
        return list;
    }
}