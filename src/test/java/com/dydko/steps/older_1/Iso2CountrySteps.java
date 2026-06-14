package com.dydko.steps.older_1;

import com.dydko.mappers.older_1.Iso2CountryMapper;
import com.dydko.models.older_1.Iso2Country;
import com.dydko.pages.older_1.Iso2CountryPage;
import com.dydko.validators.older_1.Iso2CountryValidator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.stream.Collectors;

public class Iso2CountrySteps {

    private List<Iso2Country> actual;

    @When("I read all ISO countries2")
    public void readAll() {
        actual = new Iso2CountryPage()
                .get2All()
                .stream()
                .map(Iso2CountryMapper::map2)
                .collect(Collectors.toList());
    }

    @Then("I should see following ISO countries2:")
    public void validate(DataTable table) {

        List<Iso2Country> expected = table.asMaps().stream()
                .map(row -> new Iso2Country(
                        row.get("country"),
                        row.get("alpha2"),
                        row.get("alpha3"),
                        row.get("numeric")
                ))
                .collect(Collectors.toList());

        Iso2CountryValidator.assert2Countries(actual, expected);
    }
}
