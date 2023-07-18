package com.example.dsl.controller;

import com.example.dsl.domain.Member;
import com.example.dsl.domain.Team;
import com.example.dsl.service.MemberServiceV1;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member1")
@RequiredArgsConstructor
public class MemberControllerV1 {

    private final MemberServiceV1 memberServiceV1;

    @GetMapping("memberSave")
    public String setMember(){
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");
        memberServiceV1.prevTeamDataset(team1);
        memberServiceV1.prevTeamDataset(team2);

        Member member1 = new Member("member1", 15, team1);
        Member member2 = new Member("member2", 30, team2);
        Member member3 = new Member("member3", 30, team1);
        Member member4 = new Member("member4", 35, team2);
        Member member5 = new Member("member5", 15, team1);
        Member member6 = new Member("member6", 25, team2);
        memberServiceV1.prevMemberDataset(member1);
        memberServiceV1.prevMemberDataset(member2);
        memberServiceV1.prevMemberDataset(member3);
        memberServiceV1.prevMemberDataset(member4);
        memberServiceV1.prevMemberDataset(member5);
        memberServiceV1.prevMemberDataset(member6);

        return "redirect:/";
    }

    @GetMapping("findMember1")
    public String findMember1(Model model){
        model.addAttribute("dto", memberServiceV1.findMemberV1());
        return "member1/findMember1";
    }
}
