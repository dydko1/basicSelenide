package com.dydko.models.older_1;

import lombok.Value;

@Value
public class CountryPopulation {
    String name;
    String population;
    String yearlyChange;
    String density;
}
