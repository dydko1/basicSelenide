package com.dydko.hooks;

import com.codeborne.selenide.Selenide;
import com.dydko.config.BrowserConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeScenario() {

        BrowserConfiguration.configure();
    }

    @After
    public void afterScenario() {

        Selenide.closeWebDriver();
    }
}