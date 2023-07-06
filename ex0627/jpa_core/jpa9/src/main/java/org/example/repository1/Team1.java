package org.example.repository1;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team1 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Member1> members = new ArrayList<Member1>();
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

    public List<Member1> getMembers() {
        return members;
    }

    public void setMembers(List<Member1> members1) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Team1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", members=" + members +
                '}';
    }
}