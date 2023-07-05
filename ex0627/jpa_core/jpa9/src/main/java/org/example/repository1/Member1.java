package org.example.repository1;

import javax.persistence.*;

@Entity
//@NamedQueries({
//        @NamedQuery(
//                name = "Member1.findByUsername",
//                query = "SELECT m FROM Member1 m WHERE m.username = :username"
//        ),
//        @NamedQuery(
//                name = "Member1.count",
//                query = "SELECT COUNT(m) FROM Member1 m"
//        )
//
//})
//@NamedNativeQueries({
//    @NamedNativeQuery(
//            name = "Member1.findByIdWithNative",
//            query = "SELECT id, username from Member1 where id = :id",
//            resultClass = Member1.class
//    )
//})
public class Member1 {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private int age;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team1 team;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team1 getTeam() {
        return team;
    }

    public void setTeam(Team1 team) {
        this.team = team;
    }

}
