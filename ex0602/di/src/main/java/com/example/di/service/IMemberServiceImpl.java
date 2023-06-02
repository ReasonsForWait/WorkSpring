package com.example.di.service;

import org.springframework.stereotype.Component;

@Component("service2")
public class IMemberServiceImpl implements IMemberService {

    private int num = 0;
    @Override
    public void saveMember() {
        System.out.println("회원이 정상적으로 저장되었습니다.");
    }

    @Override
    public void plusNum() {
        this.num += 1;
    }

    @Override
    public int getNum() {
        return num;
    }
}
