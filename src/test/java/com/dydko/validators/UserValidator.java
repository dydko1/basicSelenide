package com.dydko.validators;

import com.dydko.models.User;
import com.dydko.models.UserMatcher;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class UserValidator {

    public static void assertSubset(List<User> expected, List<User> actual){

        SoftAssertions softly = new SoftAssertions();
        expected.forEach(exp -> {
            boolean found = actual.stream()
                    .anyMatch(act -> UserMatcher.matches(exp, act));
            softly.assertThat(found)
                    .as("User exists: " + exp)
                    .isTrue();
        });

        softly.assertAll();
    }
}