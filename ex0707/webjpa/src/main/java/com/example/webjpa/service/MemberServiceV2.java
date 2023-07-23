package com.example.webjpa.service;

import com.example.webjpa.domain.Member;
import com.example.webjpa.dto.MemberInDTO;
import com.example.webjpa.dto.MemberOutDTO;
import com.example.webjpa.dto.page.MemberOutDTOPage;
import com.example.webjpa.dto.spec.OutDTO;
import com.example.webjpa.repository.MemberRepositoryV1;
import com.example.webjpa.repository.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceV2 {

    private final MemberRepositoryV2 memberRepositoryV2;

    // 멤버 찾기
//    @Transactional(readOnly = true)
//    public MemberOutDTO findMember(Long id){
//        MemberOutDTO dto = new MemberOutDTO();
//        dto.setMember(memberRepositoryV2.findById(id).get());
//        return dto;
//    }

    // 리스트 찾기
//    public List<MemberOutDTO> findMemberAll(){
//        List<MemberOutDTO> list = new ArrayList<>();
//        for(Member mem : memberRepositoryV2.findAll()){
//            list.add(new MemberOutDTO((mem)));
//        }
//        return list;
//    }

    // 전체 리스트 개수 구하기
    public long findCount(){
        return memberRepositoryV2.count();
    }

    // 멤버 추가
    @Transactional
    public void saveMember(String username, Integer age){
        Member member = new Member(username, age);
        Member smember = memberRepositoryV2.save(member);
        System.out.println("--------------- 저장된 값 : "+smember.getId());
    }

    // 맴버 수정
    @Transactional
    public void putMember(MemberInDTO dto){
//        Member member = memberRepositoryV2.findById(dto.getUserid().longValue()).get();
//        member.setUsername(dto.getUsername());
//        member.setAge(dto.getAge());
//        memberRepositoryV2.save(member);
//        System.out.println("------------------ 수정한 값 : "+member.getId()+", "+member.getUsername());
    }

    // 멤버 삭제
    @Transactional
    public void deleteMember(MemberInDTO dto){
//        Member member = memberRepositoryV2.findById(dto.getUserid().longValue()).get();
//        memberRepositoryV2.delete(member);
//        System.out.println("------------------ 지워진 값 : "+member.getId());
    }

//    public List<MemberOutDTO> findMemberByFirstnameEnding(MemberInDTO dto){
//        List<MemberOutDTO> list = new ArrayList<>();
//        for(Member mem : memberRepositoryV2.findByUsernameEndingWith(dto.getUsername())){
//            list.add(new MemberOutDTO((mem)));
//        }
//        return list;
//    }

//    public List<MemberOutDTO> findNamedQuery1(String username){
//        List<MemberOutDTO> list = new ArrayList<>();
//        for(Member mem : memberRepositoryV2.findByUsername(username)){
//            list.add(new MemberOutDTO(mem));
//        }
//        return list;
//    }

//    public List<MemberOutDTO> findRepositoryQuery1(String username, Integer age){
//        List<MemberOutDTO> list = new ArrayList<>();
//        for(Member mem : memberRepositoryV2.findUser(username, age)){
//            list.add(new MemberOutDTO(mem));
//        }
//        return list;
//    }

    public List<MemberOutDTO> findPageingQuery1(){
        List<MemberOutDTO> list = new ArrayList<>();
        // 단일 order 정렬
//        PageRequest pageReq = PageRequest.of(0, 5,
//                Sort.by(Sort.Direction.DESC, "age"));
        // 복수 order 정렬
        PageRequest pageReq = PageRequest.of(0, 5,
                Sort.by(Sort.Order.desc("age"), Sort.Order.asc("id")));

        Page<Member> page1 =
                memberRepositoryV2.findByAgeBetweenCustom1(20, 40, pageReq);

        System.out.println("조회된 데이터 수 : "+page1.getContent().size());
        System.out.println("전체 데이터 수 : "+page1.getTotalElements());
        System.out.println("페이지 번호 : "+page1.getNumber());
        System.out.println("전체 페이지 번호 : "+page1.getTotalPages());
        System.out.println("첫번째 페이지 여부 : "+page1.isFirst());
        System.out.println("다음 페이지 존재 여부 : "+page1.hasNext());

//        for(Member mem : page1.getContent()){
//            list.add(new MemberOutDTO(mem));
//        }
        return list;
    }

    public MemberOutDTOPage findPageingQuery11() {
        List<OutDTO> list = new ArrayList<>();

        // 복수 order 정렬
        PageRequest pageReq = PageRequest.of(0, 5,
                Sort.by(Sort.Order.desc("age"), Sort.Order.asc("id")));

        Page<Member> page1 =
                memberRepositoryV2.findByAgeBetweenCustom1(20, 40, pageReq);

        List<Member> list1 =
                memberRepositoryV2.findByAgeBetweenCustom4(20, 40,
                        Sort.by(Sort.Order.desc("age"), Sort.Order.asc("id")));

//        for(Member mem : page1.getContent()){
//            list.add(new MemberOutDTO(mem));
//        }

        MemberOutDTOPage page = new MemberOutDTOPage();
        page.setContent(list);
        page.setNowPage(page1.getNumber());
        page.setHasNext(page1.hasNext());
        page.setTotalElement(page1.getContent().size());

        return page;
    }

    public MemberOutDTOPage findPageingQuery2() {
        List<OutDTO> list = new ArrayList<>();

        // 복수 order 정렬
        PageRequest pageReq = PageRequest.of(0, 5,
                Sort.by(Sort.Order.desc("age"), Sort.Order.asc("id")));

        Slice<Member> page1 =
                memberRepositoryV2.findByAgeBetweenCustom2(20, 40, pageReq);

//        for(Member mem : page1.getContent()){
//            list.add(new MemberOutDTO(mem));
//        }

        MemberOutDTOPage page = new MemberOutDTOPage();
        page.setContent(list);
        page.setNowPage(page1.getNumber());
        page.setHasNext(page1.hasNext());
        page.setTotalElement(page1.getContent().size());

        return page;
    }
}
