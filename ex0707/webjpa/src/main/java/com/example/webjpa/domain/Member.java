package com.example.webjpa.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NamedQuery(
        name = "Member.findByUsername",
        query = "select m from Member m where m.username = :username"
)
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
//public class Member extends JpaBaseEntity{
public class Member extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private UUID id;

    private String username;

    private Integer age;

    @ManyToOne
    @JoinColumn(name="team_id", insertable=false, updatable=false)
    private Team team;

    public Member(String username) {this(username, 0);}
    public Member(String username, Integer age) {
        this(username, age, null);
    }
    public Member(String username, Integer age, Team team) {
        this.username = username;
        this.age = age;
        if(team != null){
            changeTeam(team);
        }
    }
    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }
}
