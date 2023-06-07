package com.example.thymeleaf.controller;

import com.example.thymeleaf.beans.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/basic")
public class BasicController {
    @GetMapping("/text-basic")
    public String textBasic(Model model){
        model.addAttribute("data1", "hello spring!");
        model.addAttribute("data2", "hello <b>spring!</b>");

        return "basic/text01";
    }

    @GetMapping("/date")
    public String date(Model model){
        model.addAttribute("LocalDateTime", LocalDateTime.now());
        return "basic/date";
    }

    @GetMapping("/link")
    public String link(Model model){
        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");
        return "basic/link";
    }

    @GetMapping("/literal")
    public String literal(Model model){
        model.addAttribute("data", "Spring!");

        return "basic/literal";
    }

    @GetMapping("/operation")
    public String operation(Model model){
        model.addAttribute("nullData", null);
        model.addAttribute("data1", "data1");

        return "basic/operation";
    }

    @GetMapping("/attribute")
    public String attribute(Model model){
        return "basic/attribute";
    }

    @GetMapping("/each")
    public String each(Model model){
        addUser(model);
        return "basic/each";
    }

    private void addUser(Model model){
        List<UserInfo> list = new ArrayList<>();

        list.add(new UserInfo("leekjgo21", "1231", "이건주1", "19930222"));
        list.add(new UserInfo("leekjgo22", "1232", "이건주2", "19920222"));
        list.add(new UserInfo("leekjgo23", "1233", "이건주3", "19910222"));

        model.addAttribute("list", list);
    }

    @GetMapping("/javascript")
    public String javascript(Model model){
        model.addAttribute("user", new UserInfo("leeg","123123", "이건주", "930222"));
        addUser(model);

        return "basic/javascript";
    }
}
