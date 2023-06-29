package org.example;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

@Entity @Table
public class ColumnTable5 {
    @Id @Column
    private String id;
    @Enumerated(EnumType.STRING)
    private SampleEnum sEnum;
    @Temporal(TemporalType.DATE)
    private Calendar date1;
    @Temporal(TemporalType.TIME)
    private Date date2;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date3;
    private LocalDate date4;
    private LocalTime date5;
    private LocalDateTime date6;
    @Lob
    private String clob1;
    @Lob
    private byte[] blob1;
    @Transient
    private String tran1;

    public String getTran1() {
        return tran1;
    }

    public void setTran1(String tran1) {
        this.tran1 = tran1;
    }

    public String getClob1() {
        return clob1;
    }

    public void setClob1(String clob1) {
        this.clob1 = clob1;
    }

    public byte[] getBlob1() {
        return blob1;
    }

    public void setBlob1(byte[] blob1) {
        this.blob1 = blob1;
    }

    public Calendar getDate1() {
        return date1;
    }

    public void setDate1(Calendar date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SampleEnum getsEnum() {
        return sEnum;
    }

    public void setsEnum(SampleEnum sEnum) {
        this.sEnum = sEnum;
    }

    public LocalDate getDate4() {
        return date4;
    }

    public void setDate4(LocalDate date4) {
        this.date4 = date4;
    }

    public LocalTime getDate5() {
        return date5;
    }

    public void setDate5(LocalTime date5) {
        this.date5 = date5;
    }

    public LocalDateTime getDate6() {
        return date6;
    }

    public void setDate6(LocalDateTime date6) {
        this.date6 = date6;
    }
}
