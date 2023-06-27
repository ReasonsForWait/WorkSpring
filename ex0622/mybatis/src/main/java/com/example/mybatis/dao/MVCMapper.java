package com.example.mybatis.dao;

import com.example.mybatis.dto.DeptDTO1;
import com.example.mybatis.dto.EmpDTO;
import com.example.mybatis.dto.EmpDTO2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MVCMapper {
    public int getCount();

    public String getEname();

    public Map<String,Object> getItem1();

    public List<Map<String, Object>> getItemList1();

    public List<EmpDTO> getItemList2();

    public EmpDTO getItemListWithParam1(@Param("empno") int id);

    public List<EmpDTO> getItemListWithParam2(
            @Param("deptno") int deptno,
            @Param("job") String job);

    public List<EmpDTO> getItemListWithParam3(EmpDTO2 dto);
    public List<EmpDTO> getItemListWithParam4(EmpDTO2 dto);
    public List<EmpDTO> getItemListWithParam5(EmpDTO2 dto);
    public List<EmpDTO> getItemListWithParam6(@Param("jobs") String[] jobs);
    public Integer setDept1(DeptDTO1 dto);

    public Integer modifyDept1(DeptDTO1 dto);

    public DeptDTO1 getDept1(@Param("deptno") Integer deptno);

    public Integer deleteDept1(@Param("deptno") Integer deptno);
}
