package org.example.repository4;

import javax.persistence.Entity;

@Entity
public class Seller1 extends SubEntity1{

    private String shopName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
