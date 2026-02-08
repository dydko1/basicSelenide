package com.dydko.lessonsgenericpowerfull.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HistoryPage {

    public void assertLoaded() {
        // Historia w Wikipedii ma nagłówek "Revision history of ..."
        $("#firstHeading")
                .shouldBe(visible)
                .shouldHave(text("Revision history"));
    }
}