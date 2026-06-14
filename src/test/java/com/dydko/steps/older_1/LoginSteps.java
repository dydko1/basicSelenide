package com.dydko.steps.older_1;

import com.dydko.pages.older_1.LoginPage;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Given("I open tables page {string}")
    public void openPage(String url) {
        loginPage.openUrl(url);
    }
}
