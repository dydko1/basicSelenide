package com.dydko.tests;

import com.dydko.models.Employee;
import com.dydko.pages.EmployeePage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeTest {

    private final EmployeePage employeePage = new EmployeePage();

    @Test
    void shouldFindEmployeesFromTokyo() {

        employeePage.open();

        List<Employee> employees =
                employeePage
                        .employeeTable()
                        .getEmployees();

        List<String> tokyoEmployees =
                employees.stream()
                        .filter(employee ->
                                employee.office().equals("Tokyo"))
                        .map(Employee::name)
                        .toList();

        assertThat(tokyoEmployees)
                .isNotEmpty();
    }
}