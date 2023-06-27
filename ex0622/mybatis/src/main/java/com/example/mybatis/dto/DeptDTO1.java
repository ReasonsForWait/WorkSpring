package com.example.mybatis.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("DeptDTO1")
public class DeptDTO1 {
    private Integer deptno;
    private String dname;
    private String loc;
}
