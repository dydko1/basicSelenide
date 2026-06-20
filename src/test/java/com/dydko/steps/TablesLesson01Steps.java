package com.dydko.steps;

import com.dydko.pages.LoginPage;
import com.dydko.pages.TablesLesson01Page;
import com.dydko.pages.TablesLesson02Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class TablesLesson01Steps {

    private final TablesLesson01Page tablesLesson01Page = new TablesLesson01Page();
    private final TablesLesson02Page tablesLesson02Page =
            new TablesLesson02Page();
    private final LoginPage loginPage = new LoginPage();

    @Given("user opens tables page lesson 02")
    public void userOpensTablesPage() {
        tablesLesson01Page.openPage();
    }

    @Given("user opens login page lesson 02")
    public void userOpensLoginPage() {
        loginPage.openPage();
    }

    @Then("table contains {int} rows lesson 03")
    public void tableContainsRows(
            int expectedRows) {

        int actualRows =
                tablesLesson02Page
                        .getUserTable()
                        .getRowCount();

        assertThat(actualRows)
                .isEqualTo(expectedRows);
    }
}