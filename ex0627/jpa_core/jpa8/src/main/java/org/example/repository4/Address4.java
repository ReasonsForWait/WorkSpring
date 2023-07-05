package org.example.repository4;

import org.example.repository3.Address3;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address4 {
    private String city;
    private String street;
    private String zipcode;

    public Address4() {
    }

    public Address4(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Address4 address4 = (Address4) obj;
        return Objects.equals(city, address4.city) &&
                Objects.equals(street, address4.street) &&
                Objects.equals(zipcode, address4.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipcode);
    }
}
