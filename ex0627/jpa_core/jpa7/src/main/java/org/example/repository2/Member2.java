package org.example.repository2;

import javax.persistence.*;

@Entity
@Table
public class Member2 {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String username;

    // 첫번째 방법
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="TEAM_ID", nullable = false)
//    private Team2 team2;

    // 두번째 방법
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="TEAM_ID")
    private Team2 team2;

    public Member2() {
    }

    public Member2(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team2 getTeam2() {
        return team2;
    }

    public void setTeam2(Team2 team2) {
        this.team2 = team2;
    }

    @Override
    public String toString() {
        return "Member2{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", team2=" + team2 +
                '}';
    }
}
