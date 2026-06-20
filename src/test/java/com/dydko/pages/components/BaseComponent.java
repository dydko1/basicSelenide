package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.eo.Se;

public abstract class BaseComponent {

    protected final SelenideElement root;

    protected BaseComponent(SelenideElement root) {
        this.root = root;
    }

    public SelenideElement getRoot() {
        return root;
    }
}
