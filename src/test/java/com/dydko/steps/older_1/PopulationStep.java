package com.dydko.steps.older_1;

import com.dydko.mappers.older_1.CountryPopulationMapper;
import com.dydko.models.older_1.CountryPopulation;
import com.dydko.pages.older_1.PopulationPage;
import com.dydko.pages.older_1.components.CookiesPopup;
import com.dydko.validators.older_1.CountryValidator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.open;

public class PopulationStep {

    private List<CountryPopulation> actual;

    @Given("I open tables population page {string}")
    public void i_open_tables_population_page(String url) {
        open(url);
        new CookiesPopup().acceptAllIfPresent();
    }

    @When("I read all countries")
    public void readAll() {
        actual = new PopulationPage()
                .getAll()
                .stream()
                .map(CountryPopulationMapper::map)
                .collect(Collectors.toList());
    }

    @Then("I should see following countries:")
    public void validate(DataTable table) {

        List<CountryPopulation> expected = table.asMaps().stream()
                .map(row -> new CountryPopulation(
                        row.get("name"),
                        row.get("population"),
                        row.get("yearlyChange"),
                        row.get("density")
                ))
                .collect(Collectors.toList());

        CountryValidator.assertCountries(actual, expected);
    }
}