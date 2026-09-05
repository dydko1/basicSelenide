package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.dydko.models.Employee;

import java.util.List;

public class EmployeeTableComponent extends TableComponent {

    public EmployeeTableComponent(SelenideElement root) {
        super(root);
    }

    public List<Employee> getRows() {

        return root.$$("tbody tr")
                .stream()
                .map(this::extractRow)
                .toList();
    }

    private Employee extractRow(SelenideElement row) {

        List<String> values =
                row.$$("td")
                        .texts();

        return new Employee(
                values.get(0),
                values.get(1),
                Integer.parseInt(values.get(2)),
                values.get(3),
                Integer.parseInt(values.get(4)),
                values.get(5)
        );
    }
}