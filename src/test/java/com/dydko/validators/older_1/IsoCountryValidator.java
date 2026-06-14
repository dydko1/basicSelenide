package com.dydko.validators.older_1;

import com.dydko.models.older_1.IsoCountry;

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
