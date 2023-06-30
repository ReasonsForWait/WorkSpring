package org.example.repository2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Team1 {

    @Id @Column(name="TEAM_ID")
    private String id;
    private String name;

    @OneToMany(mappedBy = "team1")
    private List<Member1> members = new ArrayList<>();

    public Team1() {
    }

    public Team1(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member1> getMembers() {
        return members;
    }

    public void setMembers(List<Member1> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Team1{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
