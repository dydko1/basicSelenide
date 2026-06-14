package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;

public abstract class TableComponent {

    protected final SelenideElement root;

    protected TableComponent(SelenideElement root) {
        this.root = root;
    }
}