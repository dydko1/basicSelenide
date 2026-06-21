package com.dydko.steps;

import com.dydko.pages.LoginLesson02Page;
import com.dydko.pages.TablesLesson02Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class TablesLesson02Steps {

    private final TablesLesson02Page tablesPage = new TablesLesson02Page();
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
                .getUserTable()
                .getRowCount();

        assertThat(actualRows)
                .isEqualTo(expectedRow);
    }
}
