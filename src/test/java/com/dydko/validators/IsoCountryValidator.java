package com.dydko.validators;

import com.dydko.models.IsoCountry;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IsoCountryValidator {
    public static void assertCountries(List<IsoCountry> actual, List<IsoCountry> expectedSubset) {

        expectedSubset.forEach(expected -> {

            IsoCountry actualCountry = actual.stream()
                    .filter(a -> a.country().equals(expected.country()))
                    .findFirst()
                    .orElseThrow(() ->
                            new AssertionError("Country not found: " + expected.country()));

            assertThat(actualCountry)
                    .usingRecursiveComparison()
                    .ignoringExpectedNullFields()
                    .isEqualTo(expected);
        });
    }
}
