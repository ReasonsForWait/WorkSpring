package com.example.sessionscope.controller;

import com.example.sessionscope.dto.SampleDTO1;
import com.example.sessionscope.dto.UserDTO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.net.URLEncoder;

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

    // 백앤드에서 쿠키 저장
    @GetMapping("/save-cookie")
    public String saveCookie(HttpServletResponse response){

        try{
            // utf-8 방식으로 인코딩 된 쿠키 값 생성
            String data1 = URLEncoder.encode("문자열1", "UTF-8");
            String data2 = URLEncoder.encode("문자열2", "UTF-8");

            // 인코딩된 해당 데이터를 Cookie 객체에 넣기
            Cookie cookie1 = new Cookie("cookie1", data1);
            Cookie cookie2 = new Cookie("cookie2", data2);

            // 쿠키가 생존할 수 있는 기간을 설정(초)
            cookie1.setMaxAge(365*24*60*60);
            cookie2.setMaxAge(365*24*60*60);

            // 해당 쿠키 객체를 response로 클라이언트에 전송
            response.addCookie(cookie1);
            response.addCookie(cookie2);
        }catch(Exception e){
            e.printStackTrace();
        }

        return "redirect:/";
    }

    @GetMapping("/load-cookie")
//    public String loadCookie(HttpServletRequest request){
//
//        try {
//            // request에서 쿠키 가져오기
//            Cookie[] cookies = request.getCookies();
//            // 쿠키 배열을 순회
//            for (Cookie cookie: cookies) {
//                // 쿠키의 값을 UTF-8 로 디코딩
//                String str = URLDecoder.decode(cookie.getValue(), "UTF-8");
//                // 이름이 일치할 경우 sysout으로 출력
//                if(cookie.getName().equals("cookie1")){
//                    System.out.println("cookie1 : "+str);
//                }else if(cookie.getName().equals("cookie2")){
//                    System.out.println("cookie2 : "+str);
//                }else{
//                    System.out.println("이 쿠키는 설정한 쿠키가 아닙니다.");
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return "redirect:/";
//    }
    public String loadCookie(@CookieValue("cookie1") String cookie1,
                             @CookieValue("cookie2") String cookie2){
        System.out.println("cookie1 : "+cookie1);
        System.out.println("cookie2 : "+cookie2);

        return "redirect:/";
    }
}



