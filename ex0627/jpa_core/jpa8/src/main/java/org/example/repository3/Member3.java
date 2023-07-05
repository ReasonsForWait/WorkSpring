package org.example.repository3;

import org.example.repository2.Address2;

import javax.persistence.*;

@Entity
@Table
public class Member3 {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    private String name;

    @Embedded
    private Address3 homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city", column = @Column(name="WORK_CITY")),
            @AttributeOverride(name="street", column = @Column(name="WORK_STREET")),
            @AttributeOverride(name="zipcode", column = @Column(name="WORK_ZIPCODE"))
    })
    private Address3 workAddress;

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

    public Address3 getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address3 homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address3 getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address3 workAddress) {
        this.workAddress = workAddress;
    }
}
