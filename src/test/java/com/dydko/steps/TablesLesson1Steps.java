package com.dydko.steps;

import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class TablesLesson1Steps {

    @Given("user opens tables page lesson 01")
    public void userOpensTablesPage() {
        open("https://the-internet.herokuapp.com/tables");
    }
}