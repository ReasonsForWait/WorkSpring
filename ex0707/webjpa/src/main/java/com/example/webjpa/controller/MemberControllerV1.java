package com.example.webjpa.controller;

import com.example.webjpa.dto.MemberInDTO;
import com.example.webjpa.service.MemberServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member1")
@RequiredArgsConstructor
public class MemberControllerV1 {

    private final MemberServiceV1 memberServiceV1;

    // id를 통한 단건 호출
    @GetMapping("detail/{id}")
    public String getMemberDetail(@PathVariable("id")long id, Model model){
        model.addAttribute("dto", memberServiceV1.findMember(id));
        return "member1/memberDetail";
    }

    // 리스트 호출
    @GetMapping("list")
    public String getMemberList(Model model){
        model.addAttribute("list", memberServiceV1.findMemberAll());
        model.addAttribute("cnt",memberServiceV1.findCount());
        return "member1/memberList";
    }

    // 멤버 입력 페이지 이동
    @GetMapping("input")
    public String getCreateMemberPage(MemberInDTO dto, Model model){
        model.addAttribute("dto", dto);
        model.addAttribute("action", "/member1/input");
        return "member1/memberInput";
    }

    // 멤버 입력
    @PostMapping("input")
//    public String setMember(MemberInDTO dto){
//        memberServiceV1.saveMember(dto.getUsername());
//        return "redirect:/";
//    }

    // 맴버 수정 페이지
    @GetMapping("modify")
    public String getModifyMemberPage(MemberInDTO dto, Model model){
        model.addAttribute("dto", dto);
        model.addAttribute("action", "/member1/modify");
        return "member1/memberModify";
    }

    // 멤버 수정
    @PostMapping("modify")
    public String putMember(MemberInDTO dto){
        memberServiceV1.putMember(dto);
        return "redirect:/";
    }

    // 멤버 삭제 페이지
    @GetMapping("delete")
    public String getDeleteMemberPage(MemberInDTO dto, Model model){
        model.addAttribute("dto", dto);
        model.addAttribute("action", "/member1/delete");
        return "member1/memberDelete";
    }

    // 멤버 삭제
    @PostMapping("delete")
    public String deleteMember(MemberInDTO dto){
        memberServiceV1.deleteMember(dto);
        return "redirect:/";
    }
}
