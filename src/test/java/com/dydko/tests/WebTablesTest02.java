package com.dydko.tests;

import com.dydko.models.Employee01;
import com.dydko.pages.WebTablesPage01;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTablesTest02 {

    private final WebTablesPage01 page =
            new WebTablesPage01();

    @Test
    void shouldGetEmployees() {
        page.open();
        List<Employee01> employee01s =
                page.employeeTable()
                        .getRows();
        assertThat(employee01s)
                .hasSize(3);
    }

    @Test
    void shouldFindEmployeesOlderThan30() {
        page.open();
        List<Employee01> employeesOver30 =
                page.employeeTable()
                        .getRows()
                        .stream()
                        .filter(employee01 ->
                                employee01.age() > 30)
                        .toList();
        assertThat(employeesOver30)
                .allMatch(employee01 ->
                        employee01.age() > 30);
    }

    @Test
    void shouldGetEmployeeEmails() {
        page.open();
        List<String> emails =
                page.employeeTable()
                        .getRows()
                        .stream()
                        .map(Employee01::email)
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
        Employee01 employee01 =
                page.employeeTable()
                        .getRows()
                        .stream()
                        .filter(item ->
                                item.firstName()
                                        .equals("Cierra"))
                        .findFirst()
                        .orElseThrow();
        assertThat(employee01.age())
                .isEqualTo(39);
        assertThat(employee01.department())
                .isEqualTo("Insurance");
    }
}