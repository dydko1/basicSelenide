package com.dydko.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public abstract class BasePage {

    protected abstract String url();

    protected abstract SelenideElement pageIdentifier();

    public void open() {
        Selenide
                .open(url());
        pageIdentifier()
                .shouldBe(Condition.visible);
    }
}
