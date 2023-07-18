package com.example.dsl.repository;

import com.example.dsl.domain.Member;
import com.example.dsl.repository.custom.MemberRepositoryCustomV1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepositoryV1 extends JpaRepository<Member, Long>
, MemberRepositoryCustomV1 {
}
