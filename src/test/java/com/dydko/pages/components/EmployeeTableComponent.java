package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.dydko.models.Employee;

import java.util.List;

public class EmployeeTableComponent extends BaseComponent {

    public EmployeeTableComponent(SelenideElement root) {
        super(root);
    }

    public List<Employee> getEmployees() {
        return root.$$("tbody tr")
                .stream()
                .map(r -> {
                    List<String> values = r.$$("td").texts();
                    return new Employee(
                            values.get(0),
                            values.get(1),
                            values.get(2),
                            Integer.parseInt(values.get(3))
                    );
                })
                .toList();
    }
}
