package com.dydko.config;


import com.codeborne.selenide.Configuration;

public class BrowserConfiguration {

    private BrowserConfiguration() {
    }

    public static void configure() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 30000;
        Configuration.headless = false;
    }
}
