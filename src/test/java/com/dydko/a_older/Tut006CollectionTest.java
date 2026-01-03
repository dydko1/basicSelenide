package com.dydko.a_older;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Tut006CollectionTest {

    private final SelenideElement formField = $("#input-example");

    @Test
    void checkboxShouldNotExist() {
        open("https://the-internet.herokuapp.com/add_remove_elements/");
        for (int i = 0; i < 5; i++) {
            $(byText("Add Element")).click();
        }

        $$(".added-manually").shouldHave(size(5));
        $$(".added-manually").last().click();
        $$("button").findBy(text("Delete")).click();
        System.out.println();
    }

    @Test
    void shouldClickLinkFromCollection() {
        open("https://the-internet.herokuapp.com/notification_message_rendered");

        $$("a")
                .findBy(text("Click here"))
                .click();

        $("#flash").shouldBe(visible);
        System.out.println(webdriver().driver().getWebDriver().getTitle());
    }
}
