package com.dydko.lessonsgenericpowerfull.tests;

import com.codeborne.selenide.Selenide;
import com.dydko.config.ConfigKeys;
import com.dydko.config.TestProperties;
import com.dydko.config.TestSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest extends TestSetup {
    @BeforeEach
    void openBaseUrl() {
        Selenide.open(TestProperties.get(ConfigKeys.App.BASE_URL));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

//    @AfterEach
//    void cleanState() {
//        clearBrowserCookies();
//        clearBrowserLocalStorage();
//    }
//
//    @AfterAll
//    static void tearDownAll() {
//        closeWebDriver();
//    }
}