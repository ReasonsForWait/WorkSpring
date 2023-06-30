package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ColumnTable6 {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String column1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    @Override
    public String toString() {
        return "ColumnTable6{" +
                "id=" + id +
                ", column1='" + column1 + '\'' +
                '}';
    }
}
