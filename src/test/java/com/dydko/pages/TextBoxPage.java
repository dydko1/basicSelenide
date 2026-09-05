package com.dydko.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.dydko.pages.components.TextBoxFormComponent;

import static com.codeborne.selenide.Selenide.$;

public class TextBoxPage extends BasePage {

    private static final String URL =
            "https://demoqa.com/text-box";

    private final TextBoxFormComponent form =
            new TextBoxFormComponent($("#userForm"));

    @Override
    protected String url() {
        return URL;
    }

    @Override
    protected SelenideElement pageIdentifier() {
        return $("#userName");
    }

    public TextBoxFormComponent form() {
        return form;
    }
}
