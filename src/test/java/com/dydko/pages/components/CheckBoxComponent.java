package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.checked;

public class CheckBoxComponent extends BaseComponent {

    protected CheckBoxComponent(SelenideElement root) {
        super(root);
    }

    private SelenideElement input() {
        return root.$("input[type='checkbox']");
    }

    public void check() {
        if (!isChecked())
            root.click();
    }

    public void uncheck() {
        if (isChecked())
            root.click();
    }

    public boolean isChecked() {
        return root.is(checked);
    }

    public void shouldBeChecked() {
        root.shouldBe(checked);
    }

    public void shouldNotBeChecked() {
        root.shouldNotBe(checked);
    }
}
