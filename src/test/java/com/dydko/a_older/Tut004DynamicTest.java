package com.dydko.a_older;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Tut004DynamicTest {

    private final SelenideElement exampleForm = $("#input-example");

    @Test
    void shouldEnableInput() {
        open("https://the-internet.herokuapp.com/dynamic_controls");
        exampleForm.$("button")
                .click();
        exampleForm.$("input")
                .setValue("Tu było Miro");
        exampleForm.$("#message")
                .shouldHave(text("It's enabled!"));
    }

    @Test
    void shouldAddAndRemoveElements() {
        open("https://the-internet.herokuapp.com/add_remove_elements/");
        $(byText("Add Element")).click();
        $(byText("Add Element")).click();
        $$(".added-manually").shouldHave(size(2));
        $(".added-manually").click();
        $$(".added-manually").shouldHave(size(1));
    }

    @Test
    void shouldHandleNotificationMessage() {
        open("https://the-internet.herokuapp.com/notification_message_rendered");
        $(byText("Click here"))
                .click();
        $("#flash-messages")
                .shouldHave(text(" Action successful"));
    }
}
