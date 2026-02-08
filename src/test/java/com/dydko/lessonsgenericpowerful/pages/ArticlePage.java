package com.dydko.lessonsgenericpowerfull.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ArticlePage {

    public void assertLoaded() {
        // nagłówek artykułu: "Java (programming language)"
        $("#firstHeading")
                .shouldBe(visible)
                .shouldHave(text("Java"));
    }
}
