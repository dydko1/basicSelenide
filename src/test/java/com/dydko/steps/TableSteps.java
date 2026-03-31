package com.dydko.steps;

import com.dydko.assertion.AssertionHelper;
import com.dydko.data.TableData;
import com.dydko.page.TablesPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class TableSteps {

    private final TablesPage tablesPage = new TablesPage();

    @Given("I open tables page {string}")
    public void openPage(String url) {
        tablesPage.openUrl(url);
    }

    @Then("I check table contains:")
    public void i_store_variables(DataTable dataTable) {
        List<Map<String, String>> expectedRows =
                dataTable.asMaps(String.class, String.class);
        TableData table = tablesPage.getTable();

        log.info("KEY COLUMN: {}", table.keyColumn());
        log.info("ACTUAL TABLE: {}", table.rows());

        expectedRows.forEach(expected -> {

            String key = expected.get(table.keyColumn());

            if (key == null) {
                throw new IllegalArgumentException(
                        "Missing key column in expected row: " + table.keyColumn()
                );
            }

            log.info("CHECKING ROW FOR KEY: {}", key);

            AssertionHelper.assertRowByKey(
                    table.rows(),
                    key,
                    expected
            );
        });
    }
}
