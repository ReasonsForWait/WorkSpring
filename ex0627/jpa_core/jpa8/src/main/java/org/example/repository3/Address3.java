package org.example.repository3;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address3 {
    private String city;
    private String street;
    private String zipcode;

    public Address3(String city, String street, String zipcode) {
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
        Address3 address3 = (Address3) obj;
        return Objects.equals(city, address3.city) &&
                Objects.equals(street, address3.street) &&
                Objects.equals(zipcode, address3.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipcode);
    }
}
