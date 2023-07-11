package com.example.webjpa.controller;

import com.example.webjpa.dto.MemberInDTO;
import com.example.webjpa.dto.MemberOutDTO;
import com.example.webjpa.dto.page.MemberOutDTOPage;
import com.example.webjpa.service.MemberServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/member2")
@RequiredArgsConstructor
public class MemberControllerV2 {

    private final MemberServiceV2 memberServiceV2;

    // id를 통한 단건 호출
    @GetMapping("detail/{id}")
    public String getMemberDetail(@PathVariable("id")long id, Model model){
        model.addAttribute("dto", memberServiceV2.findMember(id));
        return "member2/memberDetail";
    }

    // 리스트 호출
    @GetMapping("list")
    public String getMemberList(Model model){
        model.addAttribute("list", memberServiceV2.findMemberAll());
        model.addAttribute("cnt",memberServiceV2.findCount());
        return "member2/memberList";
    }

    // 멤버 입력 페이지 이동
    @GetMapping("input")
    public String getCreateMemberPage(MemberInDTO dto, Model model){
        model.addAttribute("dto", dto);
        model.addAttribute("action", "/member1/input");
        return "member2/memberInput";
    }

    // 멤버 입력
    @PostMapping("input")
    public String setMember(MemberInDTO dto){
        memberServiceV2.saveMember(dto.getUsername(),dto.getAge());
        return "redirect:/";
    }

    // 맴버 수정 페이지
    @GetMapping("modify")
    public String getModifyMemberPage(MemberInDTO dto, Model model){
        model.addAttribute("dto", dto);
        model.addAttribute("action", "/member1/modify");
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
        model.addAttribute("action", "/member1/delete");
        return "member2/memberDelete";
    }

    // 멤버 삭제
    @PostMapping("delete")
    public String deleteMember(MemberInDTO dto){
        memberServiceV2.deleteMember(dto);
        return "redirect:/";
    }

    @GetMapping("firstNameEnding")
    public String getFirstNameEndingPage(MemberInDTO dto, Model model){
        model.addAttribute("dto",dto);
        model.addAttribute("action","/member2/firstNameEnding");
        return "member2/firstNameEnding";
    }

    @PostMapping("firstNameEnding")
    public String getFirstNameEndingPageResult(MemberInDTO dto, Model model){
        List<MemberOutDTO> list = memberServiceV2.findMemberByFirstnameEnding(dto);
        model.addAttribute("list",list);
        model.addAttribute("cnt", list.size());
        return "member2/memberList";
    }

    @GetMapping("NamedQuery1")
    public String getMemberNamedQuery(@RequestParam("username") String username, Model model){
        List<MemberOutDTO> list = memberServiceV2.findNamedQuery1(username);
        model.addAttribute("list",list);
        model.addAttribute("cnt", list.size());
        return "member2/memberList";
    }

    @GetMapping("RepositoryPage1")
    public String getMemberWithPaging1(Model model){
        // 데이터 초기화
        memberServiceV2.saveMember("member1", 15);
        memberServiceV2.saveMember("member2", 30);
        memberServiceV2.saveMember("member3", 25);
        memberServiceV2.saveMember("member4", 35);
        memberServiceV2.saveMember("member5", 40);
        memberServiceV2.saveMember("member6", 25);
        memberServiceV2.saveMember("member7", 15);
        memberServiceV2.saveMember("member8", 10);
        memberServiceV2.saveMember("member9", 25);

        List<MemberOutDTO> list = memberServiceV2.findPageingQuery1();
        model.addAttribute("list",list);
        model.addAttribute("cnt", list.size());

        return "member2/memberList";
    }

    @GetMapping("RepositoryPage1Rest")
    @ResponseBody
    public ResponseEntity<MemberOutDTOPage> getMemberWithPaging1() {
        // 데이터 초기화
        memberServiceV2.saveMember("member1", 15);
        memberServiceV2.saveMember("member2", 30);
        memberServiceV2.saveMember("member3", 25);
        memberServiceV2.saveMember("member4", 35);
        memberServiceV2.saveMember("member5", 40);
        memberServiceV2.saveMember("member6", 25);
        memberServiceV2.saveMember("member7", 15);
        memberServiceV2.saveMember("member8", 10);
        memberServiceV2.saveMember("member9", 25);

        ResponseEntity<MemberOutDTOPage> response =
                new ResponseEntity<>(memberServiceV2.findPageingQuery11(), HttpStatus.OK);
        return response;
    }

    @GetMapping("RepositoryPage2Rest")
    @ResponseBody
    public ResponseEntity<MemberOutDTOPage> getMemberWithPaging2() {
        // 데이터 초기화
        memberServiceV2.saveMember("member1", 15);
        memberServiceV2.saveMember("member2", 30);
        memberServiceV2.saveMember("member3", 25);
        memberServiceV2.saveMember("member4", 35);
        memberServiceV2.saveMember("member5", 40);
        memberServiceV2.saveMember("member6", 25);
        memberServiceV2.saveMember("member7", 15);
        memberServiceV2.saveMember("member8", 10);
        memberServiceV2.saveMember("member9", 25);

        ResponseEntity<MemberOutDTOPage> response =
                new ResponseEntity<>(memberServiceV2.findPageingQuery2(), HttpStatus.OK);
        return response;
    }

    @GetMapping("RepositoryPage3Rest")
    @ResponseBody
    public ResponseEntity<MemberOutDTOPage> getMemberWithPaging3(Pageable page) {
        return null;
    }

}
