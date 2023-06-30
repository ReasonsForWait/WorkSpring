package org.example;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint( columnNames = {"column1"}),
                @UniqueConstraint(name="UniqueColumn1Column2", columnNames = {"column1","column2"})
        }
)
public class ColumnTable1 {

    @Id
    @Column
    private String id;
    @Column
    private String column1;
    @Column
    private String column2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }
}
