package org.example.repository1;

import javax.persistence.*;

// 단방향 연관관계 매핑 예제 - 1
@Entity
@Table
public class Member1 {

    @Id @Column(name="MEMBER_ID")
    private String id;
    private String username;
    
    // 단방향 연관관계 매핑
    @ManyToOne // 다대 일 관계를 정의할 때 사용하는 어노테이션
    // 이 어노테이션을 설정 안할 시 에러가 발생
    @JoinColumn(name="TEAM_ID")
    private Team1 team1;

    public Member1() {
    }

    public Member1(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team1 getTeam1() {
        return team1;
    }

    public void setTeam1(Team1 team1) {
        this.team1 = team1;
    }

    @Override
    public String toString() {
        return "Member1{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
