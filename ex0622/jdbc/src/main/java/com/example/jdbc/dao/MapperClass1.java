package com.example.jdbc.dao;

import com.example.jdbc.dto.empDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class MapperClass1 implements RowMapper<empDTO> {
    @Override
    public empDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        empDTO dto = new empDTO();
        dto.setEmpno(rs.getInt("empno"));
        dto.setEname(rs.getString("ename"));
        dto.setSal(rs.getDouble("sal"));
        return dto;
    }
}
