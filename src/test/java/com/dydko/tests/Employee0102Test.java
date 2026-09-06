package com.dydko.tests;

import com.dydko.models.Employee02;
import com.dydko.pages.EmployeePage02;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Employee0102Test {

    private final EmployeePage02 employeePage02 = new EmployeePage02();

    @Test
    void shouldFindEmployeesFromTokyo() {

        employeePage02.open();

        List<Employee02> employee02s =
                employeePage02
                        .employeeTable()
                        .getEmployees();

        List<String> tokyoEmployees =
                employee02s.stream()
                        .filter(employee02 ->
                                employee02.office().equals("Tokyo"))
                        .map(Employee02::name)
                        .toList();

        assertThat(tokyoEmployees)
                .isNotEmpty();
    }
}