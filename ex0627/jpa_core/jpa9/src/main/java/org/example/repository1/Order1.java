package org.example.repository1;

import javax.persistence.*;

@Entity
public class Order1 {

    @Id @GeneratedValue
    private Long id;
    private int orderAmount;

    @Embedded
    private Address1 address;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product1 product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Address1 getAddress() {
        return address;
    }

    public void setAddress(Address1 address) {
        this.address = address;
    }

    public Product1 getProduct() {
        return product;
    }

    public void setProduct(Product1 product) {
        this.product = product;
    }
}
