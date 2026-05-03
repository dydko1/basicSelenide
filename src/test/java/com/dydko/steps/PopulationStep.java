package com.dydko.steps;

import com.dydko.pages.components.CookiesPopup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class PopulationStep {

    @Given("I open tables population page {string}")
    public void i_open_tables_population_page(String url) {
        open(url);
        new CookiesPopup().acceptAllIfPresent();
    }

    @When("I read all countries")
    public void readAll() {

    }

    @Then("I should see following countries:")
    public void validate(DataTable table) {

    }
}