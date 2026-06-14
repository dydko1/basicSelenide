package com.dydko.validators.older_1;

import com.dydko.models.older_1.CountryPopulation;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CountryValidator {

    public static void assertCountries(List<CountryPopulation> actual, List<CountryPopulation> expectedSubset) {

        expectedSubset.forEach(expected -> {

            CountryPopulation actualCountry = actual.stream()
                    .filter(a -> a.getName().equals(expected.getName()))
                    .findFirst()
                    .orElseThrow(() -> new AssertionError("Country not found: " + expected.getName()));

            assertThat(actualCountry)
                    .usingRecursiveComparison()
                    .withEqualsForType((a, b) ->
                                    normalize(a).equals(normalize(b)),
                            String.class
                    )
                    .isEqualTo(expected);
        });
    }

    private static String normalize(String value) {
        if (value == null) return null;

        return value
                .replace('\u2212', '-')   // minus → ASCII
                .replace('\u00A0', ' ')   // non-breaking space
                .trim();
    }
}