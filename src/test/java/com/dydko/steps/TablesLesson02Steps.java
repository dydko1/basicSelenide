package com.dydko.steps;

import com.dydko.pages.LoginLesson02Page;
import com.dydko.pages.TablesLesson02Page;
import io.cucumber.java.en.Given;

public class TablesLesson02Steps {

    private final TablesLesson02Page page = new TablesLesson02Page();
    private final LoginLesson02Page  loginPage = new LoginLesson02Page();

    @Given("user opens tables page lesson 02")
    public void userOpensTableLesson02Page(){
        page.openPage();
    }

    @Given("user opens logins page lesson 02")
    public void userOpensLoginsLesson02Page(){
        loginPage.openPage();
    }
}
