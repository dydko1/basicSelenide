package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;

public abstract class BaseComponent {

    public final SelenideElement root;

    protected BaseComponent(SelenideElement root) {
        this.root = root;
    }
}
