package com.example.h0524Login.controller;

import com.example.h0524Login.Member;
import com.example.h0524Login.dto.DataDTO1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Home(){
        return "Login";
    }

    @GetMapping("Login")
    public String Login(WebRequest req){
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        System.out.println(id);
        System.out.println(pw);

        return "Login";
    }

    @GetMapping("result")
    public String result(WebRequest req, Model model){
        Member member = new Member();

        String name = req.getParameter("name");

        member.setName(req.getParameter("name"));
        model.addAttribute("name", member.getName());

        String email = req.getParameter("email");
        member.setEmail(req.getParameter("email"));
        model.addAttribute("email", member.getEmail());

        String pw = req.getParameter("pw");
        member.setPassword(req.getParameter("pw"));
        model.addAttribute("pw", member.getPassword());

        String age = req.getParameter("age");
        member.setAge(req.getParameter("age"));
        model.addAttribute("age", member.getAge());

        String career = req.getParameter("career");
        member.setCareer(req.getParameter("career"));
        model.addAttribute("career", member.getCareer());

        String major = req.getParameter("major");
        member.setMajor(req.getParameter("major"));
        model.addAttribute("major", member.getMajor());

        String[] interest = req.getParameterValues("interest");
        member.setInterest(req.getParameterValues("interest"));
        model.addAttribute("interest", member.getInterest());

        System.out.println("이름 : " + name);
        System.out.println("이메일 : " + email);
        System.out.println("비밀번호 : " + pw);
        System.out.println("나이 : " + age);
        System.out.println("주요 업무 : " + career);
        System.out.println("주요 직업 : " + major);
        for (String i:interest) {
            System.out.println("관심 분야 : " + i);
        }

        return "result";
    }

    @PostMapping("result1")
    public String result1(@ModelAttribute DataDTO1 dto, Model mo){
        mo.addAttribute("name", dto.getName());
        mo.addAttribute("email", dto.getEmail());
        mo.addAttribute("pw", dto.getPw());
        mo.addAttribute("age", dto.getAge());
        mo.addAttribute("career", dto.getCareer());
        mo.addAttribute("major", dto.getMajor());
        mo.addAttribute("interest", dto.getInterest());

        if (dto.getName().equals("이건주") && dto.getPw().equals("leerjswn21##")){
            return "result";
        } else {
            return "fail";
        }

    }
}
