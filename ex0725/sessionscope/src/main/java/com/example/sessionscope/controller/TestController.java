package com.example.sessionscope.controller;

import com.example.sessionscope.dto.SampleDTO1;
import com.example.sessionscope.dto.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"dto1Session"})
public class TestController {

    @GetMapping("/test1")
//    public String test1(HttpServletRequest request){
//        HttpSession session = request.getSession();
    public String test1(HttpSession session){
        session.setAttribute("data1","문자열1");
        return "redirect:/";
    }

    @GetMapping("/result1")
//    public String result1(HttpServletRequest request, Model model){
//        HttpSession session = request.getSession();
//    public String result1(HttpSession session, Model model){
//        String data1 = (String)session.getAttribute("data1");
    public String result1(@SessionAttribute("data1") String data1, Model model){
        model.addAttribute("data1", data1);
        return "/result1";
    }

    @GetMapping("/test2")
//    public String test2(HttpServletRequest request){
//        HttpSession session = request.getSession();
    public String test2(HttpSession session){
        session.setAttribute("data2","문자열2");
        return "redirect:/";
    }

    @GetMapping("/result2")
//    public String result2(HttpServletRequest request, Model model){
//        HttpSession session = request.getSession();
//    public String result2(HttpSession session, Model model){
//        String data1 = (String)session.getAttribute("data1");
//        String data2 = (String)session.getAttribute("data2");
    public String result2(@SessionAttribute("data1") String data1,
                          @SessionAttribute("data2") String data2,
                          Model model){
        model.addAttribute("data1", data1);
        model.addAttribute("data2", data2);
        return "/result2";
    }

    @GetMapping("/test3")
//    public String test3(HttpServletRequest request){
//        HttpSession session = request.getSession();
    public String test3(HttpSession session){
        SampleDTO1 dto1 = new SampleDTO1();
        dto1.setData1("데이터1");
        dto1.setData2("데이터2");
        session.setAttribute("dto1",dto1);
        return "redirect:/";
    }

    @GetMapping("/result3")
//    public String result3(HttpServletRequest request, Model model){
//        HttpSession session = request.getSession();
//    public String result3(HttpSession session, Model model){
//        SampleDTO1 dto1 = (SampleDTO1)session.getAttribute("dto1");
    public String result3(@SessionAttribute("dto1") SampleDTO1 dto1,
                          Model model){
        model.addAttribute("dto1", dto1);
        return "/result3";
    }

    @ModelAttribute("dto1Session")
    public SampleDTO1 dto1Session(){return new SampleDTO1();}

    @GetMapping("/test4")
//    public String test4(HttpSession session, SampleDTO1 dto1){
//        session.setAttribute("dto1",dto1);
    public String test4(
            @ModelAttribute("dto1Session") SampleDTO1 dto1){
        dto1.setData1("데이타1");
        dto1.setData2("데이타2");
        return "redirect:/";
    }

    @GetMapping("/result4")
    public String result4(
            @ModelAttribute("dto1Session") SampleDTO1 dto1){
        System.out.println(dto1.getData1());
        System.out.println(dto1.getData2());
        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "/login";
    }

    @PostMapping("/login")
    public String postLogin(
            HttpServletRequest request
            ,HttpSession session, UserDTO user){
        // 만약에 유저가 아이디 패스워드가 유효하면
        // 기존 세션을 파기
        session.invalidate();
        // 새로운 세션을 가져오기
        session = request.getSession();
        session.setAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/is-login")
    public String isLogin(@SessionAttribute("user") UserDTO user,
                          Model model){
        model.addAttribute("user", user);
        return "/islogin";
    }
}
