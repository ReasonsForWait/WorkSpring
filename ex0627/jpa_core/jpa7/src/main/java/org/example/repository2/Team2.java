package org.example.repository2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Team2 {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team2", fetch = FetchType.LAZY,
    cascade = CascadeType.PERSIST)
    private List<Member2> members = new ArrayList<>();

    public Team2() {
    }

    public Team2(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member2> getMembers() {
        return members;
    }

    public void setMembers(List<Member2> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Team2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
