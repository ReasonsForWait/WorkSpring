package com.example.webjpa.service;

import com.example.webjpa.domain.Member;
import com.example.webjpa.domain.Team;
import com.example.webjpa.repository.SelfMemberRepository;
import com.example.webjpa.repository.SelfTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SelfService {
    private final SelfMemberRepository selfMemberRepository;
    private final SelfTeamRepository selfTeamRepository;

    // 멤버 추가
    @Transactional
    public void saveMember(String username, Integer age, String teamName){
        Member member = new Member(username, age);
        Team team1 = new Team(teamName);
        selfMemberRepository.save(member);
        selfTeamRepository.save(team1);
    }
}
