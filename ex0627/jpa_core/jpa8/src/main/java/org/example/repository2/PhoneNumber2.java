package org.example.repository2;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PhoneNumber2 {

    private String number;

    @ManyToOne
    private PhoneNumberProvider2 provider;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneNumberProvider2 getProvider() {
        return provider;
    }

    public void setProvider(PhoneNumberProvider2 provider) {
        this.provider = provider;
    }
}
