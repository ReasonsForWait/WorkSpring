package com.example.mybatis.service;

import com.example.mybatis.dao.MVCMapper;
import com.example.mybatis.dto.DeptDTO1;
import com.example.mybatis.dto.EmpDTO;
import com.example.mybatis.dto.EmpDTO2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class MVCService {

    private final MVCMapper dao;

    public void getCount(Model model){
        model.addAttribute("cnt",dao.getCount());
    }

    public void getEname(Model model){
        model.addAttribute("ename",dao.getEname());
    }

    public void getItem1(Model model){
//        System.out.println("item1 : "+dao.getItem1());
        model.addAttribute("item1", dao.getItem1());
    }

    public void getItemList1(Model model){
        model.addAttribute("list", dao.getItemList1());
    }

    public void getItemList2(Model model){
        model.addAttribute("list", dao.getItemList2());
    }

    public void getItemListWithParam1(Model model,int id){
        model.addAttribute("item", dao.getItemListWithParam1(id));
    }

    public void getItemListWithParam2(Model model, int deptno, String job){
        model.addAttribute("list", dao.getItemListWithParam2(deptno, job));
    }

    public void getItemListWithParam3(Model model, EmpDTO2 dto){
        model.addAttribute("list", dao.getItemListWithParam3(dto));
    }
    public void getItemListWithParam4(Model model, EmpDTO2 dto){
        model.addAttribute("list", dao.getItemListWithParam4(dto));
    }
    public void getItemListWithParam5(Model model, EmpDTO2 dto){
        model.addAttribute("list", dao.getItemListWithParam5(dto));
    }
    public void getItemListWithParam6(Model model, String[] jobs){
        model.addAttribute("list", dao.getItemListWithParam6(jobs));
    }
    @Transactional
    public void setDept1(DeptDTO1 dto){
        System.out.println("나온 숫자는 : "+dao.setDept1(dto));
    }

    @Transactional
    public void modifyDept1(DeptDTO1 dto){
        System.out.println("나온 숫자는 : "+dao.modifyDept1(dto));
    }

    public void getDept1(Model mo, Integer deptno){
        mo.addAttribute("dto", dao.getDept1(deptno));
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteDept1(Integer deptno){
        System.out.println("삭제된 데이터 : " + dao.deleteDept1(deptno));
    }
}
