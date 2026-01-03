package com.dydko.a_older;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Tut006NegativeTest {

    private final SelenideElement formField = $("#input-example");

    @Test
    void checkboxShouldNotExist() {
        open("https://the-internet.herokuapp.com/dynamic_controls");
        $("#checkbox-example button").click();
        $("#checkbox").shouldNot(exist);
    }

    @Test
    void noElementsWithoutAction() {
        open("https://the-internet.herokuapp.com/add_remove_elements/");

        $$(".added-manually").shouldHave(size(0));
    }

    @Test
    void notificationShouldBeShown() {
        open("https://the-internet.herokuapp.com/notification_message_rendered");

        $(byText("Click here")).click();

        $("#flash")
                .shouldBe(visible)
                .shouldHave(text("Action"));
    }
}
