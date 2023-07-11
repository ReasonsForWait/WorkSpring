package com.example.webjpa.repository;

import com.example.webjpa.domain.Member;
import com.example.webjpa.dto.MemberOutDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepositoryV2 extends JpaRepository<Member, Long> {
    // username이 해당 문자로 끝나는 row만 검색
    List<Member> findByUsernameEndingWith(String username);

    // startAge와 endAge 사이의 데이터를 검색
    List<Member> findByAgeBetween(int startAge, int endAge);

    // username이 일치하고 age가 해당 값을 초과하는 row를 검색
    List<Member> findByUsernameIsAndAgeGreaterThan(String username, int age);

    // NamedQuery 사용
    List<Member> findByUsername(@Param("username") String username);

    // @Query, repository 메소드에 쿼리 정의하기
    @Query("select m from Member m where m.username = :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") Integer age);
//    Member findUser(@Param("username") String username, @Param("age") Integer age);

    // 단순 유저 이름 리스트 조회
    @Query("select m.username from Member m")
    List<String> findUsernameList();

    // 컬렉션 파라미터 바인딩
    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") List<String> list);

    // DTO 직접 조회
    @Query("select new com.example.webjpa.dto.MemberOutDTO(m.id, m.username, m.age) from Member m")
    List<MemberOutDTO> findMemberDto();
    
    // 페이징 처리 예제 1 - count 쿼리 사용
    @Query("select m from Member m where m.age between :startAge and :endAge")
    Page<Member> findByAgeBetweenCustom1(@Param("startAge") int startAge,
                                         @Param("endAge") int endAge, Pageable pageable); // count 쿼리 사용

    @Query("select m from Member m where m.age between :startAge and :endAge")
    Slice<Member> findByAgeBetweenCustom2(@Param("startAge") int startAge,
                                          @Param("endAge") int endAge, Pageable pageable); // count 쿼리 사용

    @Query("select m from Member m where m.age between :startAge and :endAge")
    List<Member> findByAgeBetweenCustom3(@Param("startAge") int startAge,
                                          @Param("endAge") int endAge, Pageable pageable); // count 쿼리 사용

    @Query("select m from Member m where m.age between :startAge and :endAge")
    List<Member> findByAgeBetweenCustom4(@Param("startAge") int startAge,
                                         @Param("endAge") int endAge, Sort sort); // count 쿼리 사용

}
