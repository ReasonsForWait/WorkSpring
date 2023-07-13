package com.example.webjpa.service;

import com.example.webjpa.domain.Member;
import com.example.webjpa.domain.Team;
import com.example.webjpa.dto.MemberOutDTO;
import com.example.webjpa.dto.MemberOutDTOWithTeam;
import com.example.webjpa.repository.MemberRepositoryV3;
import com.example.webjpa.repository.TeamRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceV3 {
    private final MemberRepositoryV3 memberRepositoryV3;
    private final TeamRepositoryV2 teamRepositoryV2;

    @Transactional
    public void prevMemberDataset(Member member){
        Member smember = memberRepositoryV3.save(member);
        System.out.println("------------------- 저장된 값 : "+smember.getId());
    }

    @Transactional
    public void prevTeamDataset(Team team){
        Team steam = teamRepositoryV2.save(team);
        System.out.println("------------------- 저장된 값 : "+steam.getId());
    }

    public List<MemberOutDTOWithTeam> getMemberWithTeamV1(){
        List<MemberOutDTOWithTeam> list = new ArrayList<>();
        for (Member mem : memberRepositoryV3.findAll()){
            list.add(new MemberOutDTOWithTeam(mem));
        }
        return list;
    }

    public List<MemberOutDTO> getMemberCustom(){
        List<MemberOutDTO> list = new ArrayList<>();
        for(Member mem : memberRepositoryV3.findMemberCustom()){
            list.add(new MemberOutDTO(mem));
        }
        return list;
    }
}
