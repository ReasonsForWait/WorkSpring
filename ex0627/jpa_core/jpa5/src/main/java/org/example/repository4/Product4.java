package org.example.repository4;

import javax.persistence.*;

@Entity
@Table
public class Product4 {

    @Id @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private Long id;

    private String name;

    public Product4() {
    }

    public Product4(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "Product4{" +
                "name='" + name + '\'' +
                '}';
    }
}
