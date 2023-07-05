package org.example.repository2;

import javax.persistence.*;

@Entity
@Table
public class PhoneNumberProvider2 {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    private String name;

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
}
