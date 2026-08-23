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
    void shouldOpenDemoQA() {

        page.fillPage();

        $("#output")
                .shouldHave(text("Mirek"));

        $("#output")
                .shouldHave(text("mirek@example.com"));
    }


}