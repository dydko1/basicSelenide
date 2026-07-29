package com.dydko.steps;

import com.dydko.pages.LoginLesson02Page;
import com.dydko.pages.TablesLesson07Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class TablesLesson02Steps {

    private final TablesLesson07Page tablesPage = new TablesLesson07Page();
    private final LoginLesson02Page loginPage = new LoginLesson02Page();

    @Given("user opens tables page lesson 02")
    public void userOpensTableLesson02Page() {
        tablesPage.openPage();
    }

    @Given("user opens logins page lesson 02")
    public void userOpensLoginsLesson02Page() {
        loginPage.openPage();
    }

    @Then("table contains {int} rows")
    public void tableContainsRows(int expectedRow) {

        int actualRows = tablesPage
                .getTable()
                .getRowCount();

        assertThat(actualRows).isEqualTo(expectedRow);
    }

    @Then("email of {string} should be {string}")
    public void verifyEmail(String lastName, String email) {
        assertThat(tablesPage.getTable()
                .getEmail(lastName))
                .isEqualTo(email);
    }
}
