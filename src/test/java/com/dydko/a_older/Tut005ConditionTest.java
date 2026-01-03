package com.dydko.a_older;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Tut005ConditionTest {

    private final SelenideElement formField = $("#input-example");

    @Test
    void existVsVisible() {
        open("https://the-internet.herokuapp.com/dynamic_controls");
        $(byText("Remove"))
                .click();
        $(byText("A checkbox"))
                .shouldNot(exist)
                .shouldNot(visible);
    }

    @Test
    void shouldDisappear() {
        open("https://the-internet.herokuapp.com/dynamic_controls");
        $(byText("Remove"))
                .click();
        $(byText("A checkbox"))
                .should(disappear);
    }

    @Test
    void shouldAppearAgain() {
        open("https://the-internet.herokuapp.com/dynamic_controls");
        $(byText("Remove"))
                .click();
        $(byText("A checkbox"))
                .should(disappear);
        $(byText("Add"))
                .click();
        $(byText("A checkbox"))
                .should(appear);

    }

    @Test
    void shouldEnableInput() {
        open("https://the-internet.herokuapp.com/dynamic_controls");

        $("#input-example button").click();

        $("#input-example input")
                .shouldBe(enabled)
                .setValue("Selenide");
    }
}
