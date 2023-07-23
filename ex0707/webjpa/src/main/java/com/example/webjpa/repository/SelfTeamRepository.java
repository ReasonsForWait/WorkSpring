package com.example.webjpa.repository;

import com.example.webjpa.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SelfTeamRepository extends JpaRepository<Team, UUID> {
}
