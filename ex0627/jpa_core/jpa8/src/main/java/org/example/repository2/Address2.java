package org.example.repository2;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Address2 {
    private String city;
    private String street;
    @Embedded
    private Zipcode2 zipcode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Zipcode2 getZipcode() {
        return zipcode;
    }

    public void setZipcode(Zipcode2 zipcode) {
        this.zipcode = zipcode;
    }
}
