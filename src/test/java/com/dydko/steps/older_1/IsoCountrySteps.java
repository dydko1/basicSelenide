package com.dydko.steps.older_1;

import com.dydko.mappers.older_1.IsoCountryMapper;
import com.dydko.models.older_1.IsoCountry;
import com.dydko.pages.older_1.IsoCountryPage;
import com.dydko.validators.older_1.IsoCountryValidator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.stream.Collectors;

public class IsoCountrySteps {

    private List<IsoCountry> actual;

    @When("I read all ISO countries")
    public void readAll() {
        actual = new IsoCountryPage()
                .getAll()
                .stream().map(IsoCountryMapper::map)
                .collect(Collectors.toList());
    }

    @Then("I should see following ISO countries:")
    public void iShouldSeeFollowingISOCountries(DataTable table) {

        List<IsoCountry> expected = table.asMaps().stream()
                .map(row -> new IsoCountry(
                        row.get("country"),
                        row.get("alpha2"),
                        row.get("alpha3"),
                        row.get("numeric")
                ))
                .collect(Collectors.toList());

        IsoCountryValidator.assertCountries(actual, expected);
    }
}
