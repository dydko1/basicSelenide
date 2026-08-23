package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;

public class SearchComponent extends BaseComponent {

    public SearchComponent(SelenideElement root) {
        super(root);
    }

    private void search(String text) {
        root.$("input")
                .setValue(text);
        root.$("button")
                .click();
    }


}
