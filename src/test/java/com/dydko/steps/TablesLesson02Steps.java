package com.dydko.steps;

import com.dydko.pages.TablesLesson07Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TablesLesson02Steps {

    private final TablesLesson07Page page = new TablesLesson07Page();

    @Given("user opens tables page lesson {int}")
    public void userOpensTablesPageLesson(int arg0) {
        page.openPage();
    }

    @And("table contains {int} rows")
    public void tableContainsRows(int expectedRows) {
        int actualRows = page
                .getTable()
                .getRowCount();

        assertThat(actualRows)
                .isEqualTo(expectedRows);
    }

    @And("email of {string} should be {string}")
    public void verifyEmail(String lastName, String expectedEmail) {
        String actualEmail = page
                .getTable()
                .getEmail(lastName);

        assertThat(actualEmail).isEqualTo(expectedEmail);
    }

    @And("user {string} exists in table")
    public void userExistsInTable(String lastName) {
        assertThat(page
                .getTable()
                .userExists(lastName)
        ).isTrue();

    }

    @Then("rows containing {string} should be returned")
    public void rowsContainingShouldBeReturned(String text) {
        List<List<String>> rows = page
                .getTable()
                .getRowsTextsContaining(text);

        System.out.println(rows);
    }

    @Then("rows matching conditions should be returned")
    public void rowsMatchingConditionsShouldBeReturned(DataTable dataTable) {
        List<String> conditions = dataTable.asList();

        List<List<String>> rows = page
                .getTable()
                .getRowsTextsContaining(conditions);
        System.out.println("-------------------- Miro --------------------");
        System.out.println(rows);
    }
}
