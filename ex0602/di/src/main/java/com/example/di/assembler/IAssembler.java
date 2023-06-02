package com.example.di.assembler;

import com.example.di.service.IMemberService;
import com.example.di.service.IMemberServiceImpl;

public class IAssembler {
    IMemberService service;

    public IAssembler() {
        this.service = new IMemberServiceImpl();

    }
}
