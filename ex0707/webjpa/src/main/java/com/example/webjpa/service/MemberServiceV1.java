package com.example.webjpa.service;

import com.example.webjpa.domain.Member;
import com.example.webjpa.dto.MemberInDTO;
import com.example.webjpa.dto.MemberOutDTO;
import com.example.webjpa.repository.MemberRepositoryV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceV1 {

    private final MemberRepositoryV1 memberRepositoryV1;

    // 멤버 찾기
    public MemberOutDTO findMember(Long id){
        MemberOutDTO dto = new MemberOutDTO();
//        dto.setMember(memberRepositoryV1.findById(id).get());
        dto.setMember(memberRepositoryV1.find(id));
        return dto;
    }

    // 리스트 찾기
    public List<MemberOutDTO> findMemberAll(){
        List<MemberOutDTO> list = new ArrayList<>();
        for(Member mem : memberRepositoryV1.findAll()){
            list.add(new MemberOutDTO((mem)));
        }
        return list;
    }

    // 전체 리스트 개수 구하기
    public long findCount(){
        return memberRepositoryV1.count();
    }

    // 멤버 추가
    @Transactional
    public void saveMember(String username){
        Member member = new Member(username);
        long id = memberRepositoryV1.save(member);
        System.out.println("--------------- 저장된 값 : "+id);
    }

    // 맴버 수정
    @Transactional
    public void putMember(MemberInDTO dto){
        Member member = memberRepositoryV1.find(dto.getUserid().longValue());
        member.setUsername(dto.getUsername());
        memberRepositoryV1.save(member);
        System.out.println("------------------ 수정한 값 : "+member.getId()+", "+member.getUsername());
    }

    // 멤버 삭제
    @Transactional
    public void deleteMember(MemberInDTO dto){
        Member member = memberRepositoryV1.find(dto.getUserid().longValue());
        memberRepositoryV1.delete(member);
        System.out.println("------------------ 지워진 값 : "+member.getId());
    }


}
