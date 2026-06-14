package com.dydko.hooks;

import com.codeborne.selenide.Selenide;
import com.dydko.config.BrowserConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeHooks() {
        BrowserConfiguration.configure();
    }
    @After
    public void afterHooks() {
        Selenide.closeWebDriver();
    }
}
