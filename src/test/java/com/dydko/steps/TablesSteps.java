package com.dydko.steps;

import com.dydko.pages.LoginPage;
import com.dydko.pages.TablesPage;
import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class TablesSteps {

    private final TablesPage tablesPage = new TablesPage();
    private final LoginPage loginPage = new LoginPage();

    @Given("user opens tables page")
    public void userOpensTablesPage() {
        tablesPage.openPage();
    }

    @Given("user opens login page")
    public void userOpensLoginPage() {
        loginPage.openPage();
    }
}