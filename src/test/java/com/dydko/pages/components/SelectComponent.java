package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;

public class SelectComponent extends BaseComponent {

    protected SelectComponent(SelenideElement root) {
        super(root);
    }

    public SelectComponent select(String option) {
        root.selectOption(option);
        return this;
    }

    public String selectedValue() {
        return root.getSelectedOption().getText();
    }

    public SelectComponent selectByValue(String value){
        root.selectOptionByValue(value);
        return this;
    }

    public void shouldHaveValue(String expected) {
        root.shouldHave(
                com.codeborne.selenide.Condition.value(expected)
        );
    }
}
