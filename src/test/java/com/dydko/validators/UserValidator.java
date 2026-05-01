package com.dydko.validators;

import com.dydko.models.User;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class UserValidator {
    public static void assertContains(List<User> actual, User expected) {
        assertThat(actual)
                .as("User not found: %s", expected)
                .anySatisfy(act ->
                        assertThat(act)
                                .usingRecursiveComparison()
                                .ignoringExpectedNullFields()
                                .isEqualTo(expected)
                );
    }
}