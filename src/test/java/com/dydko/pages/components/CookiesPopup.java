package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class CookiesPopup {

    private final SelenideElement acceptButton =
            $x("//button[.='Zgadzam się' or .='Accept' or .='Agree']");

    public void acceptAllIfPresent() {
        if (isPopupVisible()) {
            acceptButton
                    .shouldBe(visible, Duration.ofSeconds(5))
                    .shouldBe(enabled)
                    .click();
            acceptButton.should(disappear, Duration.ofSeconds(5));
        }
    }

    private boolean isPopupVisible() {
        return acceptButton.exists();
    }
}
