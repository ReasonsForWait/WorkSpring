package com.example.webjpa.dto;

import com.example.webjpa.domain.Team;
import lombok.Data;

@Data
public class TeamOutDTO {
    private Long id;
    private String name;

    public TeamOutDTO() {
    }

    public TeamOutDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

//    public TeamOutDTO(Team team){
//        this.id = team.getId();
//        this.name = team.getTeamName();
//    }
}
