package org.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table
public class ColumnTable4 {
    @Id @Column
    private String id;
    @Column(nullable = false)
    private String column1;
    @Column(unique = true)
    private String column2;
//    @Column(columnDefinition = "varchar(200) default 'empty'")
    @Column(length = 200)
    private String column3 = "empty";
    @Column(length=100)
    private String column4;
    @Column(precision = 10, scale = 2)
    private BigDecimal column5;
    @Column
    private BigInteger column6;

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

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public String getColumn4() {
        return column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    public BigDecimal getColumn5() {
        return column5;
    }

    public void setColumn5(BigDecimal column5) {
        this.column5 = column5;
    }

    public BigInteger getColumn6() {
        return column6;
    }

    public void setColumn6(BigInteger column6) {
        this.column6 = column6;
    }
}
