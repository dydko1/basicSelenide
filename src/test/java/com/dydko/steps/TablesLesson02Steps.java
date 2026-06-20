package com.dydko.steps;

import com.dydko.pages.TablesLesson02Page;
import io.cucumber.java.en.Given;

public class TablesLesson02Steps {

    private final TablesLesson02Page page = new TablesLesson02Page();

    @Given("user opens tables page lesson 02")
    public void userOpensTableLesson02Page(){
        page.openPage();
    }
}
