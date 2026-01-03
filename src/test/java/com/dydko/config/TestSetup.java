package com.dydko.config;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestSetup {

    @BeforeAll
    static void setup() {
        Configuration.browser = TestProperties.get("browser");
        Configuration.timeout = Long.parseLong(TestProperties.get("timeout"));
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
        Configuration.headless = true;

        Configuration.screenshots = false;
        Configuration.savePageSource = false;
    }
}