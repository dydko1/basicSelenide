package com.dydko.validators;

import com.dydko.models.User;

import static org.assertj.core.api.Assertions.assertThat;

public class UserValidator {

    public void validate(User actual, User expected) {

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    public void validateEmail(User actual, String expectedEmail) {
        assertThat(actual.email())
                .isEqualTo(expectedEmail);
    }
}