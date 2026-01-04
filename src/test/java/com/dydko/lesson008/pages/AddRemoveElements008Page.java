package com.dydko.lesson008.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.dydko.config.ConfigKeys;
import com.dydko.config.TestProperties;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.*;


@Getter
public class AddRemoveElements008Page {

    public void openPage() {
        open(TestProperties.get(ConfigKeys.App.BASE_URL )+ "/add_remove_elements/");
    }

    private SelenideElement addButton =
            $("button[onclick='addElement()']");

    private ElementsCollection deleteButtons =
            $$(".added-manually");


}