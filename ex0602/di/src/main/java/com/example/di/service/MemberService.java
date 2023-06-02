package com.example.di.service;

import org.springframework.stereotype.Component;

@Component("service1")
public class MemberService {
    public void saveMemver(){
        System.out.println("회원을 저장하였습니다.");
    }
}
