package com.dydko.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    public void openPage() {
        open(getUrl());
        verifyPageLoaded();
    }

    protected abstract String getUrl();

    protected abstract SelenideElement getPageIdentifier();

    private void verifyPageLoaded() {
        getPageIdentifier()
                .shouldBe(Condition.visible);
    }
}
