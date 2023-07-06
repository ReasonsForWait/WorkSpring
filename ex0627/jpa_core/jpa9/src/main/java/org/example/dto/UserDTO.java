package org.example.dto;

import org.example.repository1.Team1;

public class UserDTO {
    private String username;
    private Integer age;
    private Team1 team1;

    public UserDTO() {
    }

    public UserDTO(String username, Integer age, Team1 team1) {
        this.username = username;
        this.age = age;
        this.team1 = team1;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Team1 getTeam1() {
        return team1;
    }

    public void setTeam1(Team1 team1) {
        this.team1 = team1;
    }
}
