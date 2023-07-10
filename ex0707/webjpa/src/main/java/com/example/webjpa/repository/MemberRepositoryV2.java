package com.example.webjpa.repository;

import com.example.webjpa.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepositoryV2 extends JpaRepository<Member, Long> {
    // username이 해당 문자로 끝나는 row만 검색
    List<Member> findByUsernameEndingWith(String username);

    // startAge와 endAge 사이의 데이터를 검색
    List<Member> findByAgeBetween(Integer startAge, Integer endAge);

    // username이 일치하고 age가 해당 값을 초과하는 row를 검색
    List<Member> findByUsernameIsAndAgeGreaterThan(String username, int age);
    // 순서 column - 조건식 - 접미어
}
