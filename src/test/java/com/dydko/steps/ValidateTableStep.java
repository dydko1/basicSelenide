package com.dydko.steps;

import com.dydko.data.TableData1;
import com.dydko.page.ValidateTablesPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class ValidateTableStep {

    private final ValidateTablesPage tablesPage = new ValidateTablesPage();

    @Then("I validate table contains:")
    public void iValidateTableContains(DataTable dataTable) {
        List<Map<String, String>> expectedRows =
                dataTable.asMaps(String.class, String.class);

        TableData1 table=tablesPage.getTable();
    }
}
