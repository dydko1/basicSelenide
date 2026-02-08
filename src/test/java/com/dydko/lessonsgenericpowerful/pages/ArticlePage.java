package com.dydko.lessonsgenericpowerful.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ArticlePage {

    public void assertLoaded() {
        $("#firstHeading")
                .shouldBe(visible)
                .shouldHave(text("Java"));
    }
}
