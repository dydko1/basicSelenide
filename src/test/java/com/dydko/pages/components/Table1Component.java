package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;

public abstract class Table1Component {

    protected final SelenideElement root;

    protected Table1Component(SelenideElement root) {
        this.root = root;
    }
}