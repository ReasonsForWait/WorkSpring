package org.example.repository2;

import javax.persistence.*;

@Entity
@Table
public class Locker2 {

    @Id
    @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member2 member;

    public Locker2() {
    }

    public Locker2(String name) {
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

    public Member2 getMember() {
        return member;
    }

    public void setMember(Member2 member) {
        this.member = member;
    }
}
