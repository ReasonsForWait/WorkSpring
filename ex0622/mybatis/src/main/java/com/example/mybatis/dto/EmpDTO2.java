package com.example.mybatis.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("EmpDTO2")
public class EmpDTO2 {
//    private int deptno;
    private Integer deptno;
    private String job;
}
