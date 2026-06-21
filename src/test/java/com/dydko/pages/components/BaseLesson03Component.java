package com.dydko.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.RequiredArgsConstructor;

public abstract class BaseLesson03Component {

    protected final SelenideElement  root;

    public BaseLesson03Component(SelenideElement root) {
        this.root = root;
    }

    public SelenideElement  getRoot() {
        return root;
    }
}
