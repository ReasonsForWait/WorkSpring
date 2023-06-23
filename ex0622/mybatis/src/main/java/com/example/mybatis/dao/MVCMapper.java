package com.example.mybatis.dao;

import com.example.mybatis.dto.EmpDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MVCMapper {
    public int getCount();

    public String getEname();

    public Map<String,Object> getItem1();

    public List<EmpDTO> getItem2();

    public List<EmpDTO> getItemListParam(EmpDTO dto);
}
