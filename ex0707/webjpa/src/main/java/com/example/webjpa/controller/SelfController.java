package com.example.webjpa.controller;

import com.example.webjpa.dto.MemberInDTO;
import com.example.webjpa.dto.MemberOutDTO;
import com.example.webjpa.service.SelfService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/self")
@RequiredArgsConstructor
public class SelfController {
    private final SelfService selfService;
    @GetMapping("/save")
    public String savePageController(MemberInDTO dto, Model model){
        model.addAttribute("dto", dto);
        model.addAttribute("action","/self/save");
        return "/self/MemberSavePage";
    }

    @PostMapping("/save")
    public String saveController(MemberInDTO dto){
        selfService.saveMember(dto.getUsername(), dto.getAge(), dto.getTeamname());
        return "redirect:/";
    }
}
