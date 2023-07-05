package org.example.repository2;

import javax.persistence.*;

@Entity
@Table
public class Member2 {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    private String name;

    @Embedded
    private Address2 address;

    @Embedded
    private PhoneNumber2 phoneNumber;

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

    public Address2 getAddress() {
        return address;
    }

    public void setAddress(Address2 address) {
        this.address = address;
    }

    public PhoneNumber2 getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber2 phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
