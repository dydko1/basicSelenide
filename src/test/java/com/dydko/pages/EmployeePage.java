package com.dydko.pages;

import com.dydko.pages.components.EmployeeTableComponent;

import static com.codeborne.selenide.Selenide.$;

public class EmployeePage extends BasePage {

    private final EmployeeTableComponent employeeTable =
            new EmployeeTableComponent($("table"));

    @Override
    protected String url() {
        return "https://example.com";
    }

    @Override
    protected com.codeborne.selenide.SelenideElement pageIdentifier() {
        return $("table");
    }

    public EmployeeTableComponent employeeTable() {
        return employeeTable;
    }
}