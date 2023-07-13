package com.example.webjpa.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team")
    List<Member> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    @PostLoad
    public void PostLoad(){System.out.println("Team Entity PostLoad");}
    @PrePersist
    public void PrePersist(){System.out.println("Team Entity PrePersist");}
    @PreUpdate
    public void PreUpdate(){System.out.println("Team Entity PreUpdate");}
    @PreRemove
    public void PreRemove(){System.out.println("Team Entity PreRemove");}
    @PostPersist
    public void PostPersist(){System.out.println("Team Entity PostPersist");}
    @PostUpdate
    public void PostUpdate(){System.out.println("Team Entity PostUpdate");}
    @PostRemove
    public void PostRemove(){System.out.println("Team Entity PostRemove");}
}
