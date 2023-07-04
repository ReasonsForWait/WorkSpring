package org.example.repository7;

import java.io.Serializable;
import java.util.Objects;

public class GrandChildId1 implements Serializable {
    private ChildId1 child;
    private String id;

    public GrandChildId1() {
    }

    public GrandChildId1(ChildId1 child, String id) {
        this.child = child;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null || getClass() != obj.getClass() ) return false;
        GrandChildId1 that = (GrandChildId1) obj;
        return Objects.equals(child, that.child) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(child, id);
    }
}
