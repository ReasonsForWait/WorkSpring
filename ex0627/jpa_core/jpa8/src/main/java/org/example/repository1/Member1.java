package org.example.repository1;

import javax.persistence.*;

@Entity
@Table
public class Member1 {
    // id
    @Id
    @GeneratedValue
    @Column
    private Long id;
    // 이름
    private String name;
    // 주소
    @Embedded
    private Address1 address;
    // 기간
    @Embedded
    private Period1 period;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address1 getAddress() {
        return address;
    }

    public void setAddress(Address1 address) {
        this.address = address;
    }

    public Period1 getPeriod() {
        return period;
    }

    public void setPeriod(Period1 period) {
        this.period = period;
    }
}
