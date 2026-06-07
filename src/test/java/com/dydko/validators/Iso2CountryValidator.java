package com.dydko.validators;

import com.dydko.models.Iso2Country;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Iso2CountryValidator {

    public static void assert2Countries(List<Iso2Country> actual, List<Iso2Country> expectedSubset) {

        expectedSubset.forEach(expected -> {

            Iso2Country actualCountry = actual.stream()
                    .filter(a -> a.getCountry().equals(expected.getCountry()))
                    .findFirst()
                    .orElseThrow(() ->
                            new AssertionError("Country not found: " + expected.getCountry()));

            assertThat(actualCountry)
                    .usingRecursiveComparison()
                    .ignoringExpectedNullFields()
                    .isEqualTo(expected);
        });
    }
}
