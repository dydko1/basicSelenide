package com.dydko.config;

import com.codeborne.selenide.Configuration;

public class BrowserConfiguration {

    public static void configure() {

        Configuration.browser = "chrome";

        Configuration.browserSize =
                "1920x1080";

        Configuration.headless = false;

        Configuration.timeout = 10000;

        Configuration.baseUrl =
                "https://the-internet.herokuapp.com";
    }
}