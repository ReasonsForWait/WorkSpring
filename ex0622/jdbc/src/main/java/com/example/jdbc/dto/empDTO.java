package com.example.jdbc.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class empDTO {
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private LocalDateTime hiredate;
    private double sal;
    private double comm;
    private int deptno;
}