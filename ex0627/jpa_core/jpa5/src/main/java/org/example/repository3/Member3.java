package org.example.repository3;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Member3 {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @ManyToMany
    @JoinTable(
            name = "MEMBER_PRODUCT",
            joinColumns = @JoinColumn(name="MEMBER_ID"),
            inverseJoinColumns = @JoinColumn(name="PRODUCT_ID")
    )
    private List<Product3> product3 = new ArrayList<>();

    public Member3() {
    }

    public Member3(String username) {
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

    public List<Product3> getProduct3() {
        return product3;
    }

    public void setProduct3(List<Product3> product3) {
        this.product3 = product3;
    }
}
