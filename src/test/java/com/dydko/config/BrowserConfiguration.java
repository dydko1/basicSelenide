package com.dydko.config;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

public class BrowserConfiguration {

    private BrowserConfiguration() {
    }

    public static void configure(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1024x768";
        Configuration.timeout = 5000;
        Configuration.pageLoadTimeout = 10000;
        Configuration.headless = false;
    }
}