package com.dydko.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Customer {

    private String firstName;
    private String surname;
    private String pesel;
    private Address address;
}
