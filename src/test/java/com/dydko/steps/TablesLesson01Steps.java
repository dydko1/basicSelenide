package com.dydko.steps;

import static com.codeborne.selenide.Selenide.open;
import io.cucumber.java.en.Given;

public class TablesLesson01Steps {

    @Given("user opens tables page lesson 01")
    public void userOpensTableLesson01Page() {
        open("https://the-internet.herokuapp.com/tables");
    }
}