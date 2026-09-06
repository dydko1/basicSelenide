package com.dydko.pages;

import com.dydko.pages.components.EmployeeTableComponent02;

import static com.codeborne.selenide.Selenide.$;

public class EmployeePage02 extends BasePage {

    private final EmployeeTableComponent02 employeeTable =
            new EmployeeTableComponent02($("table"));

    @Override
    protected String url() {
        return "https://example.com";
    }

    @Override
    protected com.codeborne.selenide.SelenideElement pageIdentifier() {
        return $("table");
    }

    public EmployeeTableComponent02 employeeTable() {
        return employeeTable;
    }
}