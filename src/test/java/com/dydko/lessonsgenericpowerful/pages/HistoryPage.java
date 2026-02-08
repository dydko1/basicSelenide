package com.dydko.lessonsgenericpowerful.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HistoryPage {
    private final SelenideElement heading = $("#firstHeading"); // lub inny pewny marker
        private final SelenideElement historyForm = $("#pagehistory"); // jeśli istnieje

    public HistoryPage shouldBeLoaded() {
        heading.shouldBe(visible);
        historyForm.shouldBe(visible);
        return this;
    }
}