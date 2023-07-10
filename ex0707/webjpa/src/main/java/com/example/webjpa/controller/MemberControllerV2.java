package com.example.webjpa.controller;

import com.example.webjpa.dto.MemberInDTO;
import com.example.webjpa.dto.MemberOutDTO;
import com.example.webjpa.service.MemberServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/member2")
@RequiredArgsConstructor
public class MemberControllerV2 {
    
    private final MemberServiceV2 memberServiceV2;

    // id를 통한 단건 호출
    @GetMapping("detail/{id}")
    public String getMemberDetail(@PathVariable("id") long id, Model model){
        model.addAttribute("dto", memberServiceV2.findMember(id));
        return "member2/memberDetail";
    }

    // 리스트 호출
    @GetMapping("list")
    public String getMemberList(Model model){
        model.addAttribute("list", memberServiceV2.findMemberAll());
        model.addAttribute("cnt", memberServiceV2.findCount());
        return "member2/memberList";
    }

    // 멤버 입력
    @GetMapping("input")
    public String getCreateMemberPage(MemberInDTO dto, Model model){
        model.addAttribute("dto", dto);
        model.addAttribute("action", "/member2/input");
        return "member2/memberInput";
    }

    // 멤버 입력
    @PostMapping("input")
    public String setMember(MemberInDTO dto){
        memberServiceV2.saveMember(dto.getUsername(), dto.getAge());
        return "redirect:/";
    }

    // 멤버 수정 페이지
    @GetMapping("modify")
    public String getModifyMemberPage(MemberInDTO dto, Model model){
        model.addAttribute("dto", dto);
        model.addAttribute("action", "/member2/modify");
        return "member2/memberModify";
    }
    // 멤버 수정
    @PostMapping("modify")
    public String putMember(MemberInDTO dto){
        memberServiceV2.putMember(dto);
        return "redirect:/";
    }

    // 멤버 삭제 페이지
    @GetMapping("delete")
    public String getDeleteMemberPage(MemberInDTO dto, Model model){
        model.addAttribute("dto", dto);
        model.addAttribute("action", "/member2/delete");
        return "member2/memberDelete";
    }

    // 멤버 삭제
    @PostMapping("delete")
    public String deletMember(MemberInDTO dto){
        memberServiceV2.deleteMember(dto);
        return "redirect:/";
    }

    @GetMapping("firstNameEnding")
    public String getFirstNameEndingPage(MemberInDTO dto, Model model){
        model.addAttribute("dto", dto);
        model.addAttribute("action", "/member2/firstNameEnding");
        return "member2/firstNameEnding";
    }

    @PostMapping("firstNameEnding")
    public String geFirstNameEndingPageResult(MemberInDTO dto, Model model){
        List<MemberOutDTO> list = memberServiceV2.findMemberByFirstnameEnding(dto);
        model.addAttribute("list", list);
        model.addAttribute("cnt", list.size());
        return "member2/memberlist";
    }
}
