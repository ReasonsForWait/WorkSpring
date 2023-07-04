package org.example.repository8;

import javax.persistence.*;

@Entity
public class Child2 {

    @Id
    @GeneratedValue
    @Column(name ="CHILD_ID")
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name ="PARENT_ID")
    private Parent2 parent;

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

    public Parent2 getParent() {
        return parent;
    }

    public void setParent(Parent2 parent) {
        this.parent = parent;
    }
}
