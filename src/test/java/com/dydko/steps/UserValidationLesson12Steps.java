package com.dydko.steps;

import com.dydko.models.User;
import com.dydko.testsupport.ScenarioContext;
import com.dydko.testsupport.TestContextKey;
import io.cucumber.java.en.Then;
import static org.assertj.core.api.Assertions.assertThat;

public class UserValidationLesson12Steps {

    @Then("loaded user should have first name {string}")
    public void loadedUserShouldHaveFirstName(String expectedFirstName) {
        User user =
                ScenarioContext
                        .get()
                        .get(TestContextKey.USER);
        assertThat(user.firstName())
                .isEqualTo(expectedFirstName);
    }
}
