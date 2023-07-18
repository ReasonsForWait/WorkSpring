package com.example.dsl.service;

import com.example.dsl.domain.Member;
import com.example.dsl.domain.Team;
import com.example.dsl.dto.MemberOutDTO;
import com.example.dsl.repository.MemberRepositoryV1;
import com.example.dsl.repository.TeamRepositoryV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceV1 {

    private final MemberRepositoryV1 memberRepositoryV1;
    private final TeamRepositoryV1 teamRepositoryV1;

    @Transactional
    public void prevMemberDataset(Member member){
        Member smember = memberRepositoryV1.save(member);
        System.out.println("-----------------저장된 값 : "+smember.getId());
    }

    @Transactional
    public void prevTeamDataset(Team team){
        Team steam = teamRepositoryV1.save(team);
        System.out.println("-----------------저장된 팀 : "+steam.getId());
    }

    public MemberOutDTO findMemberV1(){
        return new MemberOutDTO(memberRepositoryV1.findMemberV1());
    }
}
