package com.dydko.models;

import lombok.Value;

//@Value
public record IsoCountry(
        String country,
        String alpha2,
        String alpha3,
        String numeric) {
}
