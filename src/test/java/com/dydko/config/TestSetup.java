package com.dydko.config;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestSetup {

    @BeforeAll
    static void setup() {
        Configuration.browser = TestProperties.get(ConfigKeys.Browser.NAME);
        Configuration.timeout = Long.parseLong(ConfigKeys.Browser.TIMEOUT);
        Configuration.headless = false;
        Configuration.browserSize = TestProperties.get(ConfigKeys.Browser.SIZE);
        Configuration.browserPosition = "0x0";
        Configuration.headless = true;
        Configuration.headless = Boolean.parseBoolean(TestProperties.get(ConfigKeys.Browser.HEADLESS));

        Configuration.screenshots = false;
        Configuration.savePageSource = false;
    }
}