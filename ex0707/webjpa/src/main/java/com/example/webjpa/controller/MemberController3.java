package com.example.webjpa.controller;

import com.example.webjpa.domain.Member;
import com.example.webjpa.domain.Team;
import com.example.webjpa.dto.MemberOutDTO;
import com.example.webjpa.dto.MemberOutDTOWithTeam;
import com.example.webjpa.service.MemberServiceV3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/member3")
@RequiredArgsConstructor
public class MemberController3 {

    private final MemberServiceV3 memberServiceV3;

//    @GetMapping("memberSave")
//    public String setMembers(){
////        Team team1 = new Team(("team1"));
////        Team team2 = new Team(("team2"));
//        memberServiceV3.prevTeamDataset(team1);
//        memberServiceV3.prevTeamDataset(team2);
//
//        Member member1 = new Member("member1", 15, team1);
//        Member member2 = new Member("member2", 30, team2);
//        Member member3 = new Member("member3", 30, team1);
//        Member member4 = new Member("member4", 35, team2);
//        Member member5 = new Member("member5", 15, team1);
//        Member member6 = new Member("member6", 25, team2);
//        memberServiceV3.prevMemberDataset(member1);
//        memberServiceV3.prevMemberDataset(member2);
//        memberServiceV3.prevMemberDataset(member3);
//        memberServiceV3.prevMemberDataset(member4);
//        memberServiceV3.prevMemberDataset(member5);
//        memberServiceV3.prevMemberDataset(member6);
//
//        return "redirect:/";
//    }

    @GetMapping("memberEntityGraphV1")
    public String getMemberEntityGraphV1(Model model){
        List<MemberOutDTOWithTeam> list = memberServiceV3.getMemberWithTeamV1();
        model.addAttribute("list",list);
        model.addAttribute("cnt",list.size());
        return "member3/entityGraphV1";
    }

    @GetMapping("memberCustom")
    public String getMemberCustomEntity(Model model){
        List<MemberOutDTO> list = memberServiceV3.getMemberCustom();
        model.addAttribute("list", list);
        model.addAttribute("cnt", list.size());
        return "member2/memberList";
    }
}
