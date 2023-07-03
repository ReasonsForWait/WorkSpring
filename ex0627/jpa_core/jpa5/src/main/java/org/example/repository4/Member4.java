package org.example.repository4;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Member4 {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct4> memberProducts = new ArrayList<>();

    public Member4() {
    }

    public Member4(String username) {
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

    public List<MemberProduct4> getMemberProducts() {
        return memberProducts;
    }

    public void setMemberProducts(List<MemberProduct4> memberProducts) {
        this.memberProducts = memberProducts;
    }

    @Override
    public String toString() {
        return "Member4{" +
                "username='" + username + '\'' +
                '}';
    }
}
