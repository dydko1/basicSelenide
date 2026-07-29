package com.dydko.pages;

import com.codeborne.selenide.SelenideElement;
import com.dydko.pages.components.UserTableLesson07Component;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class TablesLesson07Page extends BasePage {

    private static final String URL =
            "https://the-internet.herokuapp.com/tables";

    private final SelenideElement pageHeader = $("h3");

    private UserTableLesson07Component table =
            new UserTableLesson07Component($("#table1"));

    @Override
    protected String getUrl() {
        return URL;
    }

    @Override
    protected SelenideElement getPageIdentifier() {
        return pageHeader;
    }
}
