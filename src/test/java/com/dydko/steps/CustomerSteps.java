package com.dydko.steps;

import com.dydko.context.ScenarioContext;
import com.dydko.factory.CustomerFactory;
import com.dydko.utils.DataProcessor;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerSteps {

    private final ScenarioContext context = new ScenarioContext();

    @When("I build customer request")
    public void iBuildCustomerRequest(DataTable table) {
        List<Map<String, String>> rows = table.asMaps();

        DataProcessor processor = new DataProcessor(context);

        for (Map<String, String> row : rows) {

            Map<String, String> processed = new HashMap<>();

            for (Map.Entry<String, String> entry : row.entrySet()) {

                String key = entry.getKey();
                String value = entry.getValue();

                String resolved = processor.process(value, row);

                processed.put(key, resolved);
            }

            String json = CustomerFactory.build(processed);

            System.out.println("FINAL JSON:");
            System.out.println(json);
        }
    }
}
