package com.dydko.pages;

import com.codeborne.selenide.SelenideElement;
import com.dydko.pages.components.RadioButtonComponent;

import static com.codeborne.selenide.Selenide.$;

public class RadioButtonPage extends BasePage {

    private final RadioButtonComponent radioButtons =
            new RadioButtonComponent(
                    $("#yesRadio")
                            .parent()
                            .parent()
            );

    @Override
    protected String url() {
        return "https://demoqa.com/radio-button";
    }

    @Override
    protected SelenideElement pageIdentifier() {
        return $("#yesRadio");
    }

    public RadioButtonComponent radioButtons() {
        return radioButtons;
    }
}