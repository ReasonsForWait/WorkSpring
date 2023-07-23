package com.example.webjpa.repository;

import com.example.webjpa.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryV1 {

    private final EntityManager em;

    // 생성 쿼리
//    public Long save(Member member){
//        if(member.getId() == null){
//            em.persist(member);
//        }else {
//            em.merge(member);
//        }
//        return member.getId();
//    }

    // 단건 조회
    public Member find(Long id){
        return em.find(Member.class, id);
    }

    // 전체 조회
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    // 삭제
//    public Long delete(Member member){
//        em.remove(member);
//        return member.getId();
//    }

    // 단건 조회
    public Optional<Member> findById(Long id){
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    // 전체 로우 개수
    public long count(){
        return em.createQuery(
                "select count(m) from Member m", Long.class).getSingleResult();
    }

}
