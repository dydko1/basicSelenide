package com.dydko.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TablesLesson02Page extends BasePage {

    private static final String URL =
            "https://the-internet.herokuapp.com/tables";

    private final SelenideElement pageHeader = $("h3");


    @Override
    protected String getUrl() {
        return URL;
    }

    @Override
    protected SelenideElement getPageIdentifier() {
        return pageHeader;
    }

    public String getPageTitle() {
        return getPageIdentifier()
                .getText();
    }
}
