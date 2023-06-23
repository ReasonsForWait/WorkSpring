package com.example.mybatis.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("EmpDTO")
public class EmpDTO {
    private String ename;
    private String empno;
    private int sal;
}
