package com.dydko.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TextBoxPage extends BasePage {

    private static final String URL =
            "https://demoqa.com/text-box";

    @Override
    protected String url() {
        return URL;
    }

    @Override
    protected SelenideElement pageIdentifier() {
        return $("#userName");
    }

    public void fillPage(){

        open();

        $("#userName")
                .setValue("Mirek");

        $("#userEmail")
                .setValue("mirek@example.com");

        $("#currentAddress")
                .setValue("Ruda Śląska");

        $("#submit")
                .scrollTo()
                .shouldBe(Condition.visible)
                .click();
    }
}
