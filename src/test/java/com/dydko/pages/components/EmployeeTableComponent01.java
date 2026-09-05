package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.dydko.models.Employee01;

import java.util.List;

public class EmployeeTableComponent01 extends BaseComponent {

    public EmployeeTableComponent01(SelenideElement root) {
        super(root);
    }

    public List<Employee01> getEmployees() {
        return root.$$("tbody tr")
                .stream()
                .map(r -> {
                    List<String> values = r.$$("td").texts();
                    return new Employee01(
                            values.get(0),
                            values.get(1),
                            values.get(2),
                            Integer.parseInt(values.get(3))
                    );
                })
                .toList();
    }
}
