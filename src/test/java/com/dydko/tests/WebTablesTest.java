package com.dydko.tests;

import com.dydko.models.Employee;
import com.dydko.pages.WebTablesPage;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTablesTest {

    private final WebTablesPage page =
            new WebTablesPage();

    @Test
    void shouldFindEmployeeByFirstName() {
        page.open();
        Employee employee =
                page.employeeTable()
                        .findByFirstName("Cierra")
                        .orElseThrow();
        assertThat(employee.getLastName())
                .isEqualTo("Vega");
        assertThat(employee.getAge())
                .isEqualTo(39);
        assertThat(employee.getDepartment())
                .isEqualTo("Insurance");
    }

    @Test
    void shouldNotFindEmployee() {
        page.open();
        Optional<Employee> employee =
                page.employeeTable()
                        .findByFirstName("Mirek");
        Optional<Employee> employee1 =
                page.employeeTable()
                        .findByFirstName("Cierra1");
        assertThat(employee)
                .isEmpty();
        assertThat(employee1)
                .isEmpty();
    }

    @Test
    void shouldFindEmployeesByDepartment() {
        page.open();
        List<Employee> employees =
                page.employeeTable()
                        .findByDepartment("Insurance");
        assertThat(employees)
                .isNotEmpty()
                .allMatch(employee ->
                        employee.getDepartment()
                                .equals("Insurance"));
    }

    @Test
    void shouldFindEmployeesOlderThan30() {
        page.open();
        List<Employee> employees = page.employeeTable()
                .findEmployees(employee ->
                        employee.getAge() > 30);
        assertThat(employees).isNotEmpty()
                .allMatch(employee ->
                        employee.getAge() > 30);
    }

    @Test
    void shouldFindHighlyPaidEmployeesOver30() {
        page.open();
        List<Employee> employees = page.employeeTable()
                .findEmployees(e -> e.getAge() > 30
                        && e.getSalary() > 5000);
        assertThat(employees)
                .allMatch(e -> e.getAge() > 30
                        && e.getSalary() > 5000);
    }

    @Test
    void shouldFindEmployeesByCondition() {
        page.open();
        Predicate<Employee> isFromInsurance =
                employee ->
                        employee.getDepartment()
                                .equals("Insurance");
        List<Employee> employees =
                page.employeeTable()
                        .findEmployees(isFromInsurance);
        assertThat(employees)
                .allMatch(isFromInsurance);
    }

    @Test
    void shouldFindEmployeesOlderThan30FromInsurance() {
        page.open();
        Predicate<Employee> isOlderThan30 =
                employee -> employee.getAge() > 30;
        Predicate<Employee> worksInInsurance =
                employee ->
                        employee.getDepartment()
                                .equals("Insurance");
        Predicate<Employee> condition =
                isOlderThan30
                        .and(worksInInsurance);
        List<Employee> employees =
                page.employeeTable()
                        .findEmployees(condition);
        assertThat(employees)
                .isNotEmpty()
                .allMatch(condition);
    }
}
