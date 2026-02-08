package com.dydko.lessonsgenericpowerful.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HistoryPage {

    public void assertLoaded() {
        $("#firstHeading")
                .shouldBe(visible)
                .shouldHave(text("Revision history"));
    }
}