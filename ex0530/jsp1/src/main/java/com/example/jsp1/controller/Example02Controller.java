package com.example.jsp1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.security.PublicKey;

@Controller
@RequestMapping("/example02")
public class Example02Controller {

    @GetMapping("/test1")
    public String result(HttpServletRequest req){
        String data1 = req.getParameter("data1");
        String data2 = req.getParameter("data2");
        String[] data3 = req.getParameterValues("data3");

        System.out.println("data1 : " + data1);
        System.out.println("data2 : " + data2);
        for (String data: data3) {
            System.out.println("data3 : " + data);
        }

        return "example02/result";
    }

    @PostMapping("/test2")
//    public String test2(HttpServletRequest req){
    public String test2(WebRequest req){
        String data1 = req.getParameter("data1");
        String data2 = req.getParameter("data2");
        String[] data3 = req.getParameterValues("data3");

        System.out.println("data1 : " + data1);
        System.out.println("data2 : " + data2);
        for (String data: data3) {
            System.out.println("체크된 data3의 값 : " + data);
        }

        return "example02/result";
    }

    @GetMapping("/test3/{data1}/{data2}/{data3}")
    public String test3(@PathVariable String data1, @PathVariable String data2, @PathVariable String data3){
        System.out.println("data1 : " + data1);
        System.out.println("data2 : " + data2);
        System.out.println("data3 : " + data3);

        return "example02/result";
    }

    @GetMapping("/test4/{data1}")
    public String test4(@PathVariable int[] data1){
        for (int dt:data1) {
            System.out.println(dt);
        }

        return "example02/result";
    }

    @GetMapping("/test5")
    public String test5(@RequestParam("data1") int d1, @RequestParam("data2") int d2, @RequestParam("data3") int[] d3){
        System.out.println(d1);
        System.out.println(d2);
        for (int dt:d3) {
            System.out.println(dt);
        }

        return "example02/result";
    }

    @GetMapping("/test6")
    public String test6(@RequestParam("data1") int d1,
                        @RequestParam(value = "data2", required = false) String d2,
                        @RequestParam(value = "data3", defaultValue = "5") int d3){
        System.out.println(d1);
        if(d2 != null){
            System.out.println(d2);
        }
        System.out.println(d3);

        return "example02/result";
    }

    @GetMapping("/test7")
    public String test7(){
        return "example02/result";
    }
}
