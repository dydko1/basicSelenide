package com.dydko.lesson008.pages;

import com.codeborne.selenide.SelenideElement;
import com.dydko.config.ConfigKeys;
import com.dydko.config.TestProperties;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class DynamicControls008Page {

    public void openPage() {
        open(TestProperties.get(ConfigKeys.App.BASE_URL) + "/dynamic_controls");
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