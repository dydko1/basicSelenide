package com.dydko.tests;

import com.dydko.models.Employee;
import com.dydko.pages.WebTablesPage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTablesTest {

    private final WebTablesPage page =
            new WebTablesPage();

    @Test
    void shouldGetEmployees() {
        page.open();
        List<Employee> employees =
                page.employeeTable()
                        .getRows();
        assertThat(employees)
                .hasSize(3);
    }

    @Test
    void shouldFindEmployeesOlderThan30() {
        page.open();
        List<Employee> employeesOver30 =
                page.employeeTable()
                        .getRows()
                        .stream()
                        .filter(employee ->
                                employee.age() > 30)
                        .toList();
        assertThat(employeesOver30)
                .allMatch(employee ->
                        employee.age() > 30);
    }

    @Test
    void shouldGetEmployeeEmails() {
        page.open();
        List<String> emails =
                page.employeeTable()
                        .getRows()
                        .stream()
                        .map(Employee::email)
                        .toList();
        assertThat(emails)
                .contains(
                        "cierra@example.com",
                        "alden@example.com",
                        "kierra@example.com"
                );
    }

    @Test
    void shouldFindCierra() {
        page.open();
        Employee employee =
                page.employeeTable()
                        .getRows()
                        .stream()
                        .filter(item ->
                                item.firstName()
                                        .equals("Cierra"))
                        .findFirst()
                        .orElseThrow();
        assertThat(employee.age())
                .isEqualTo(39);
        assertThat(employee.department())
                .isEqualTo("Insurance");
    }
}