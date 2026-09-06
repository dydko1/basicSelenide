package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.dydko.models.Employee01;

import java.util.List;

public class EmployeeTableComponent01 extends TableComponent {

    public EmployeeTableComponent01(SelenideElement root) {
        super(root);
    }

    public List<Employee01> getRows() {

        return root.$$("tbody tr")
                .stream()
                .map(this::extractRow)
                .toList();
    }

    private Employee01 extractRow(SelenideElement row) {

        List<String> values =
                row.$$("td")
                        .texts();

        return new Employee01(
                values.get(0),
                values.get(1),
                Integer.parseInt(values.get(2)),
                values.get(3),
                Integer.parseInt(values.get(4)),
                values.get(5)
        );
    }
}