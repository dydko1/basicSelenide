package com.dydko.models;

import lombok.Value;

@Value
public class CountryPopulation {
    String name;
    String population;
    String yearlyChange;
    String density;
}
