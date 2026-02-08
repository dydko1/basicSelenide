package com.dydko.lessonsgenericpowerful.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ArticlePage {
    private final SelenideElement heading = $("#firstHeading");

    public ArticlePage shouldBeLoaded() {
        heading.shouldBe(visible);
        return this;
    }
}
