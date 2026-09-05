package com.dydko.tests;

import com.dydko.models.Employee01;
import com.dydko.pages.EmployeePage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Employee01Test {

    private final EmployeePage employeePage = new EmployeePage();

    @Test
    void shouldFindEmployeesFromTokyo() {

        employeePage.open();

        List<Employee01> employee01s =
                employeePage
                        .employeeTable()
                        .getEmployees();

        List<String> tokyoEmployees =
                employee01s.stream()
                        .filter(employee01 ->
                                employee01.office().equals("Tokyo"))
                        .map(Employee01::name)
                        .toList();

        assertThat(tokyoEmployees)
                .isNotEmpty();
    }
}