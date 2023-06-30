package org.example.repository1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Team1 {

    @Id @Column(name="TEAM_ID")
    private String id;
    private String name;

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

    @Override
    public String toString() {
        return "Team1{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
