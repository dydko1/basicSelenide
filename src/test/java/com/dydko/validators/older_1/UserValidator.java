package com.dydko.validators.older_1;

import com.dydko.models.older_1.User;

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