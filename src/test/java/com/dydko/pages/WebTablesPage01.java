package com.dydko.pages;

import com.codeborne.selenide.SelenideElement;
import com.dydko.pages.components.EmployeeTableComponent01;

import static com.codeborne.selenide.Selenide.$;

public class WebTablesPage01 extends BasePage {
    private final EmployeeTableComponent01 employeeTable =
            new EmployeeTableComponent01(
                    $("table")
            );

    @Override
    protected String url() {
        return "https://demoqa.com/webtables";
    }

    @Override
    protected SelenideElement pageIdentifier() {
        return $("table");
    }

    public EmployeeTableComponent01 employeeTable() {
        return employeeTable;
    }
}