package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

    private String city;
    private String strret;
    private String zipcode;

    protected Address() {
    }

    public Address(String city, String strret, String zipcode) {
        this.city = city;
        this.strret = strret;
        this.zipcode = zipcode;
    }

}
