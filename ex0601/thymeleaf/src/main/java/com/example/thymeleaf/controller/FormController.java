package com.example.thymeleaf.controller;

import com.example.thymeleaf.beans.UserDTO;
import com.example.thymeleaf.beans.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/form")
public class FormController {

    @GetMapping("/object")
    public String object(Model model){
        UserInfo bean = new UserInfo("leekjgo21", "1234", "이건주", "930222");

        model.addAttribute("userVO", bean);
        model.addAttribute("action", "/form/result");
        return "form/object";
    }

    @PostMapping("/result")
    public String result(UserDTO dto){
        System.out.println(dto.getUser_id());
        return "form/result";
    }

    @GetMapping("/check")
    public String check(Model model){
        UserDTO bean = new UserDTO();

        bean.setUser_id("leekjgo21");
        bean.setUser_chk(false);
        model.addAttribute("userVO", bean);
        model.addAttribute("action","/form/result2");
        return "form/check";
    }

    @PostMapping("/result2")
    public String result2(UserDTO dto){
        System.out.println(dto.getUser_id());
        System.out.println(dto.getUser_chk());
        return "form/result";
    }

    @GetMapping("/checks")
    public String checks(Model model){
        UserDTO bean = new UserDTO();
        List<String> list = new ArrayList<>();
        list.add("서울");
        list.add("인천");
        bean.setStates(list);

        // 포멧
        Map<String, String> regions = new LinkedHashMap<>();
        regions.put("서울", "1");
        regions.put("인천", "2");
        regions.put("부산", "3");

        model.addAttribute("reg", regions);
        model.addAttribute("userVO", bean);
        model.addAttribute("action", "form/result3");

        return "form/chechks";
    }

    @PostMapping("/result3")
    public String result3(UserDTO dto){
        System.out.println(dto.getUser_id());
        System.out.println(dto.getStates());
        return "form/result";
    }

    @GetMapping("radio")
    public String radio(Model model){

        return "form/radio";
    }
}
