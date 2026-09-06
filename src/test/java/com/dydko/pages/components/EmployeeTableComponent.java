package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.dydko.models.Employee;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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

    public Optional<Employee> findByFirstName(String firstName) {
        return getRows()
                .stream()
                .filter(e -> e.getFirstName()
                        .equals(firstName))
                .findFirst();
    }

    public List<Employee> findByDepartment(String department) {
        return getRows()
                .stream()
                .filter(e ->
                        e.getDepartment()
                                .equals(department))
                .toList();
    }

    public List<Employee> findEmployees(Predicate<Employee> condition) {
        return getRows()
                .stream()
                .filter(condition)
                .toList();
    }

    private Employee extractRow(SelenideElement row) {
        List<String> values = row.$$("td")
                .texts();
        return Employee.builder()
                .firstName(values.get(0))
                .lastName(values.get(1))
                .age(Integer.parseInt(values.get(2)))
                .email(values.get(3))
                .salary(Integer.parseInt(values.get(4)))
                .department(values.get(5))
                .build();
    }
}