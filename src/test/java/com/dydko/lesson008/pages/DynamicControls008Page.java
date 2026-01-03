package com.dydko.lesson008.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class DynamicControls008Page {

    public void openPage() {
        open("https://the-internet.herokuapp.com/dynamic_controls");
    }

    private final SelenideElement checkbox =
            $("#checkbox");
    private final SelenideElement toggleCheckboxButton =
            $("#checkbox-example button");

    private final SelenideElement input =
            $("#input-example input");
    private final SelenideElement toggleInputButton =
            $("#input-example button");
}