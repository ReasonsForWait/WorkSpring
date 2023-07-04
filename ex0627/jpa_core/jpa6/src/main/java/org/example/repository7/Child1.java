package org.example.repository7;

import javax.persistence.*;

@Entity
@IdClass(ChildId1.class)
public class Child1 {
    @Id
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public Parent1 parent1;

    @Id
    @Column(name="CHILD_ID")
    private String childId;

    private String name;

    public Parent1 getParent1() {
        return parent1;
    }

    public void setParent1(Parent1 parent1) {
        this.parent1 = parent1;
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
