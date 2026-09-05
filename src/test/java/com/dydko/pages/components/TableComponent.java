package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;

public abstract class TableComponent extends BaseComponent {

    protected TableComponent(SelenideElement root) {
        super(root);
    }
}