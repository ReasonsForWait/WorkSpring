package com.example.webjpa.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Team extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private UUID id;

    @Column
    private String teamname;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public Team(String teamname) {
        this.teamname = teamname;
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
