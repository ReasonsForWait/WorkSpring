package com.example.webjpa.service;

import com.example.webjpa.domain.Member;
import com.example.webjpa.dto.MemberInDTO;
import com.example.webjpa.dto.MemberOutDTO;
import com.example.webjpa.repository.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceV2 {
    private final MemberRepositoryV2 memberRepositoryV2;

    // 멤버 찾기
    public MemberOutDTO findMember(Long id){
        MemberOutDTO dto = new MemberOutDTO();
//        dto.setMember(memberRepositoryV1.findById(id).get()); Optional을 써서 get이 붙어야한다 아래줄과 같은 역할
        dto.setMember(memberRepositoryV2.findById(id).get());
        return dto;
    }

    // 리스트 찾기
    public List<MemberOutDTO> findMemberAll(){
        List<MemberOutDTO> list = new ArrayList<>();
        for(Member mem : memberRepositoryV2.findAll()){
            list.add(new MemberOutDTO((mem)));
        }
        return list;
    }

    // 전체 리스트 개수 구하기
    public long findCount(){
        return memberRepositoryV2.count();
    }

    @Transactional
    public void saveMember(String username, Integer age){
        Member member = new Member(username, age);
        Member smember = memberRepositoryV2.save(member);
        System.out.println("------- 저장된 값 : " + smember.getId());
    }

    // 멤버 수정
    public void putMember(MemberInDTO dto){
        Member member = memberRepositoryV2.findById(dto.getUserid().longValue()).get();
        member.setUsername(dto.getUsername());
        member.setAge(dto.getAge());
        memberRepositoryV2.save(member);
        System.out.println("-------- 수정된 값 : " + member.getId() + ", " + member.getUsername());
    }

    // 멤버 삭제
    @Transactional
    public void deleteMember(MemberInDTO dto){
        Member member = memberRepositoryV2.findById(dto.getUserid().longValue()).get();
        memberRepositoryV2.delete(member);
        System.out.println("-------- 삭제된 값 : " + member.getId());
    }

    public List<MemberOutDTO> findMemberByFirstnameEnding(MemberInDTO dto){
        List<MemberOutDTO> list = new ArrayList<>();
        for (Member mem : memberRepositoryV2.findByUsernameEndingWith(dto.getUsername())){
            list.add(new MemberOutDTO((mem)));
        }
        return list;
    }
}
