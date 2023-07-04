package org.example.repository7;

import javax.persistence.*;

@Entity
@IdClass(GrandChildId1.class)
public class GrandChild1 {

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID"),
            @JoinColumn(name = "CHILD_ID")
    })
    private Child1 child1;

    @Id
    @Column(name = "GRANDCHILD_ID")
    private String id;
    private String name;

    public Child1 getChild1() {
        return child1;
    }

    public void setChild1(Child1 child1) {
        this.child1 = child1;
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
}
