package com.example.webjpa.repository;

import com.example.webjpa.domain.Member;
import com.example.webjpa.repository.custom.MemberRepositoryCustom;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepositoryV3 extends JpaRepository<Member, Long>,
        MemberRepositoryCustom {

    @Override
    @EntityGraph(attributePaths = {"team"})
    List<Member> findAll();
}
