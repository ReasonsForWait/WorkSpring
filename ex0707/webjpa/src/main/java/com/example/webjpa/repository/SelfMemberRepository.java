package com.example.webjpa.repository;

import com.example.webjpa.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SelfMemberRepository extends JpaRepository<Member, UUID> {
}
