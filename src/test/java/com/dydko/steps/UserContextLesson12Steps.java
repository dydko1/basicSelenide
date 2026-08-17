package com.dydko.steps;

import com.dydko.models.User;
import com.dydko.pages.TablesLesson07Page;
import com.dydko.testsupport.ScenarioContext;
import com.dydko.testsupport.TestContextKey;
import io.cucumber.java.en.Given;

public class UserContextLesson12Steps {

    private final TablesLesson07Page page =
            new TablesLesson07Page();

    @Given("user {string} is loaded")
    public void userIsLoaded(
            String lastName) {

        User user =
                page.getTable()
                        .getUser(lastName);

        ScenarioContext
                .get()
                .set(
                        TestContextKey.USER,
                        user
                );
    }
}