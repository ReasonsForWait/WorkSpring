package com.example.webjpa.repository;

import com.example.webjpa.domain.Team;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TeamRepositoryV1 {

    private final EntityManager em;

    // 저장
    public Team save(Team team){
        em.persist(team);
        return team;
    }

    // 삭제
    public void delete(Team team){
        em.remove(team);
    }

    // 리스트 검색
    public List<Team> findAll(){
        return em.createQuery("SELECT t RFOM Team t", Team.class).getResultList();
    }

    // 로우 검색
    public Optional<Team> findById(Long id){
        Team team = em.find(Team.class, id);
        // null을 처리하기 위한 Optional 객체 생성
        return Optional.ofNullable(team);
    }

    // 카운트
    public long count(){
        return em.createQuery("SELECT count(t) FROM Team t", Long.class).getSingleResult();
    }
}
