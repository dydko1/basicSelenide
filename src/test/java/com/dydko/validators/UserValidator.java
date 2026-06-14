package com.dydko.validators;

import com.dydko.models.User;

import static org.assertj.core.api.Assertions.assertThat;

public class UserValidator {

    public void validate(User user) {

        assertThat(user).isNotNull();

        assertThat(user.email())
                .contains("@");

        assertThat(user.website())
                .startsWith("http");

        assertThat(user.due())
                .isNotBlank();
    }
}