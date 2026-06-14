package com.dydko.validators.older_1;

import com.dydko.models.older_1.CountryGDP;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CountryGDPValidator {

    public static void assertContains(List<CountryGDP> actual, CountryGDP expected) {

        assertThat(actual)
                .as("Country not found: %s", expected)
                .anySatisfy(
                        act ->
                                assertThat(act)
                                        .usingRecursiveComparison()
                                        .ignoringExpectedNullFields()
                                        .isEqualTo(expected));
    }
}
