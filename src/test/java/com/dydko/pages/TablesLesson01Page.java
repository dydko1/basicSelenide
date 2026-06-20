package com.dydko.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TablesLesson01Page extends BasePage {

    public static final String URL = "https://the-internet.herokuapp.com/tables";

    // private final SelenideElement table = $("#table1");
    private SelenideElement pageHeader = $("h3");

    @Override
    protected String getUrl() {
        return URL;
    }

    @Override
    protected SelenideElement getPageIdentifier() {
        return pageHeader;
    }

    public String gePageTitle() {
        return getPageIdentifier().getText();
    }
}