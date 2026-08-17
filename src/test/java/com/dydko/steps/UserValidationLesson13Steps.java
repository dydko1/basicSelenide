package com.dydko.steps;

import com.dydko.models.User;
import com.dydko.testsupport.ScenarioContext;
import com.dydko.testsupport.TestContextKey;
import com.dydko.validators.UserValidator;
import io.cucumber.java.en.Then;

public class UserValidationLesson13Steps {

    private final UserValidator validator =
            new UserValidator();

    @Then("loaded user should match expected user")
    public void loadedUserShouldMatchExpectedUser() {

        User actualUser =
                ScenarioContext
                        .get()
                        .get(TestContextKey.USER);

        User expectedUser =
                ScenarioContext
                        .get()
                        .get(TestContextKey.EXPECTED_USER);

        validator.validate(
                actualUser,
                expectedUser
        );
    }
}