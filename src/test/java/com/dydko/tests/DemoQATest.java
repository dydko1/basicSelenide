package com.dydko.tests;

import com.codeborne.selenide.Condition;
import com.dydko.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

class DemoQATest {

    TextBoxPage page = new TextBoxPage();

    @Test
    void shouldFillTextBox() {
        page.open();
        page.form()
                .setName("Mirek")
                .setEmail("mirek@example.com")
                .setCurrentAddress("Ruda Śląska")
                .setPermanentAddress("Polska")
                .submit();
    }
}