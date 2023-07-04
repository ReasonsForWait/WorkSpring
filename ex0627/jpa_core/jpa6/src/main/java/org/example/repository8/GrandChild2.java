package org.example.repository8;

import javax.persistence.*;

@Entity
public class GrandChild2 {

    @Id
    @GeneratedValue
    @Column(name = "GRANDCHILD_ID")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="CHILD_ID")
    private Child2 child;

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

    public Child2 getChild() {
        return child;
    }

    public void setChild(Child2 child) {
        this.child = child;
    }
}
