package com.example.dsl.repository;

import com.example.dsl.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepositoryV1 extends JpaRepository<Team, Long> {
}
