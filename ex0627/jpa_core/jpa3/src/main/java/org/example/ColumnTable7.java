package org.example;

import javax.persistence.*;

@Entity
@Table
@TableGenerator(
        name="COLUMN_SEQ_GENERATOR",
        table="COLUMN_SEQ",
        pkColumnName = "SEQ_ID",
        valueColumnName = "SEQ_NUM",
        pkColumnValue = "Col7",
        initialValue = 0,
        allocationSize = 1
)
public class ColumnTable7 {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
        generator = "COLUMN_SEQ_GENERATOR")
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
        return "ColumnTable7{" +
                "id=" + id +
                ", column1='" + column1 + '\'' +
                '}';
    }
}
