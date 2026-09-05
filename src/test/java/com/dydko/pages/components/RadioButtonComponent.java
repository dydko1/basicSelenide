package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;

public class RadioButtonComponent extends BaseComponent {

    public RadioButtonComponent(SelenideElement root) {
        super(root);
    }

    public RadioButtonComponent select(String option) {
        root.$$("label")
                .findBy(text(option))
                .click();
        return this;
    }

    public boolean isSelected(String option) {
        return radioButton(option)
                .is(checked);
    }

    public void shouldBeSelected(String option) {
        radioButton(option)
                .shouldBe(checked);
    }

    public List<String> getOptions() {
        return root.$$("label")
                .texts();
    }

    private SelenideElement radioButton(String option) {
        return root.$x(
                ".//label[normalize-space(text())='"
                        + option
                        + "']/preceding-sibling::input[@type='radio']"
        );
    }
}
