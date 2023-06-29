package org.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ColumnTable2 {

    @Id
    @Column
    private String id;
    @Column
    private String column1;
    private String column2;
    @Column(name="column3")
    private String userColumn3;
    private int intColumn1;
    private Integer intColumn2;
    private float floatColumn1;
    private double doubleColumn1;
    private byte byteColumn1;
    private short shortColumn1;
    private long longColumn1;
    private char charColumn1;

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

    public String getUserColumn3() {
        return userColumn3;
    }

    public void setUserColumn3(String userColumn3) {
        this.userColumn3 = userColumn3;
    }

    public int getIntColumn1() {
        return intColumn1;
    }

    public void setIntColumn1(int intColumn1) {
        this.intColumn1 = intColumn1;
    }

    public Integer getIntColumn2() {
        return intColumn2;
    }

    public void setIntColumn2(Integer intColumn2) {
        this.intColumn2 = intColumn2;
    }

    public float getFloatColumn1() {
        return floatColumn1;
    }

    public void setFloatColumn1(float floatColumn1) {
        this.floatColumn1 = floatColumn1;
    }

    public double getDoubleColumn1() {
        return doubleColumn1;
    }

    public void setDoubleColumn1(double doubleColumn1) {
        this.doubleColumn1 = doubleColumn1;
    }

    public byte getByteColumn1() {
        return byteColumn1;
    }

    public void setByteColumn1(byte byteColumn1) {
        this.byteColumn1 = byteColumn1;
    }

    public short getShortColumn1() {
        return shortColumn1;
    }

    public void setShortColumn1(short shortColumn1) {
        this.shortColumn1 = shortColumn1;
    }

    public long getLongColumn1() {
        return longColumn1;
    }

    public void setLongColumn1(long longColumn1) {
        this.longColumn1 = longColumn1;
    }

    public char getCharColumn1() {
        return charColumn1;
    }

    public void setCharColumn1(char charColumn1) {
        this.charColumn1 = charColumn1;
    }
}
