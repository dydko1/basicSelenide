package com.dydko.steps.older_1;

import com.dydko.mappers.older_1.CountryGDPMapper;
import com.dydko.pages.older_1.CountryGDPPage;
import com.dydko.validators.older_1.CountryGDPValidator;
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