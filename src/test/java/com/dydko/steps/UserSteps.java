package com.dydko.steps;

import com.dydko.mappers.UserMapper;
import com.dydko.models.User;
import com.dydko.pages.TablesPage;
import com.dydko.testsupport.TestContext;
import com.dydko.validators.UserValidator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSteps {

    private final TablesPage tablesPage =
            new TablesPage();

    private final UserMapper mapper =
            new UserMapper();

    private final UserValidator validator =
            new UserValidator();

    private final TestContext context =
            new TestContext();

    @Given("user opens tables page")
    public void openPage() {
        tablesPage.openPage();
    }

    @When("user reads first row")
    public void readFirstRow() {

        User user =
                tablesPage
                        .openPage()
                        .table1()
                        .getRows()
                        .stream()
                        .map(mapper::map)
                        .findFirst()
                        .orElseThrow();

        context.setCurrentUser(user);
    }

    @Then("user should be valid")
    public void userShouldBeValid() {

        validator.validate(
                context.getCurrentUser()
        );
    }
}