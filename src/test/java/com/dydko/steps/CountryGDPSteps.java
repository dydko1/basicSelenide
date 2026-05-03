package com.dydko.steps;

import com.dydko.models.CountryGDPMapper;
import com.dydko.pages.CountryGDPPage;
import com.dydko.validators.CountryGDPValidator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class CountryGDPSteps {

    private final CountryGDPPage page = new CountryGDPPage();

    @Then("GDP table contains countries")
    public void validate(DataTable table) {

        var expected = CountryGDPMapper.from(table);
        var actual = page.getAll();

        expected.forEach(exp ->
                CountryGDPValidator.assertContains(actual, exp)
        );
    }
}