package org.example.repository3;

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

    // 양방향 연관관계는 결국 양쪽 다 신경을 써야 함
    // 실수로 둘 중 하나만 호출해서 양방향이 깨질 수가 있으므로
    // Setter에서 해당 양방향을 한꺼번에 처리하는 로직을 담는다.
    public void setTeam1(Team1 team1) {
        // 기존 팀과 관계를 제거
        if(this.team1 != null){
            this.team1.getMembers().remove(this);
        }
        this.team1 = team1;
        team1.getMembers().add(this);
    }

    @Override
    public String toString() {
        return "Member1{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
