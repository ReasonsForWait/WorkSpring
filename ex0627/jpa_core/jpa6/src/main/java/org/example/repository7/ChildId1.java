package org.example.repository7;

import org.example.repository6.AccountId2;

import java.io.Serializable;
import java.util.Objects;

public class ChildId1 implements Serializable {

    private String parentId; // parent fk and child pk
    private String childId;
    public ChildId1() {
    }
    public ChildId1(String parentId, String childId) {
        this.parentId = parentId;
        this.childId = childId;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null || getClass() != obj.getClass() ) return false;
        ChildId1 that = (ChildId1) obj;
        return Objects.equals(parentId, that.parentId) && Objects.equals(childId, that.childId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentId, childId);
    }
}
