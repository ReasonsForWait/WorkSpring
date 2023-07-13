package com.example.webjpa.dto;

import com.example.webjpa.domain.Member;
import lombok.Getter;

@Getter
public class MemberOutDTOWithTeam {

    private Long userid;
    private String username;
    private Integer age;
    private TeamOutDTO team;

    public MemberOutDTOWithTeam() {
    }

    public MemberOutDTOWithTeam(Long userid, String username, Integer age) {
        this.userid = userid;
        this.username = username;
        this.age = age;
    }

    public MemberOutDTOWithTeam(Member member) {
        userid = member.getId();
        username = member.getUsername();
        age = member.getAge();
        team = new TeamOutDTO(member.getTeam());
    }

    public void setMember(Member member){
        userid = member.getId();
        username = member.getUsername();
        age = member.getAge();
        team = new TeamOutDTO(member.getTeam());
    }

}
