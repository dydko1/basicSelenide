package com.dydko.pages;

import com.dydko.pages.components.EmployeeTableComponent01;

import static com.codeborne.selenide.Selenide.$;

public class EmployeePage extends BasePage {

    private final EmployeeTableComponent01 employeeTable =
            new EmployeeTableComponent01($("table"));

    @Override
    protected String url() {
        return "https://example.com";
    }

    @Override
    protected com.codeborne.selenide.SelenideElement pageIdentifier() {
        return $("table");
    }

    public EmployeeTableComponent01 employeeTable() {
        return employeeTable;
    }
}