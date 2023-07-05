package org.example.repository2;

import javax.persistence.Embeddable;

@Embeddable
public class Zipcode2 {
    private String zipcode;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
