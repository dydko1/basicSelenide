package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.dydko.models.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public List<Employee> getEmployeesSortedByAge() {
        return getRows()
                .stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .toList();
    }

    public List<Employee> getEmployeesSortedBySalaryDescending() {
        return getRows()
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .toList();
    }

    public Optional<Employee> findHighestPaidEmployee() {
        return getRows()
                .stream()
                .max(Comparator.comparing(Employee::getSalary));
    }

    public List<Employee> getEmployeesSortedByDepartmentAndAge() {
        return getRows()
                .stream()
                .sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getAge))
                .toList();
    }

    public <R> List<R> getValues(Function<Employee, R> mapper) {
        return getRows()
                .stream()
                .map(mapper)
                .toList();
    }

    public Map<String, List<Employee>> groupByDepartment() {
        return getRows()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment
                        )
                );
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