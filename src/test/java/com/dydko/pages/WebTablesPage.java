package com.dydko.pages;

import com.codeborne.selenide.SelenideElement;
import com.dydko.pages.components.EmployeeTableComponent;

import static com.codeborne.selenide.Selenide.$;

public class WebTablesPage extends BasePage {
    private final EmployeeTableComponent employeeTable =
            new EmployeeTableComponent(
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

    public EmployeeTableComponent employeeTable() {
        return employeeTable;
    }
}