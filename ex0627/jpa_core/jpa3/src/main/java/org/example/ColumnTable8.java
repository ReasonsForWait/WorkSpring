package org.example;

import jdk.jfr.Enabled;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class ColumnTable8 {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    @Column(length = 16)
    private UUID id;

    private String column1;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
        return "ColumnTable8{" +
                "id=" + id +
                ", column1='" + column1 + '\'' +
                '}';
    }
}
