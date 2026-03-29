package com.dydko.steps;

import com.dydko.data.TableData;
import com.dydko.page.TablesPage;
import com.dydko.helper.AssertionHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class TableSteps {

    private final TablesPage tablesPage = new TablesPage();

    @Given("I open tables page")
    public void openPage() {
        tablesPage.openUrl("https://the-internet.herokuapp.com/tables");
    }

    @Then("I check table contains:")
    public void i_store_variables(DataTable dataTable) {
        List<Map<String, String>> expectedRows =
                dataTable.asMaps(String.class, String.class);

        TableData table = tablesPage.getTable();

        log.info("KEY COLUMN: {}", table.getKeyColumn());
        log.info("ACTUAL TABLE: {}", table.getRows());

        expectedRows.forEach(expected -> {
            String key = expected.get(table.getKeyColumn());
            if (key == null) {
                throw new IllegalArgumentException(
                        "Missing key column in expected row: " + table.getKeyColumn()
                );
            }
            log.info("CHECKING ROW FOR KEY: {}", key);
            AssertionHelper.assertRowByKey(
                    table.getRows(),
                    key,
                    expected
            );
        });
    }
}
