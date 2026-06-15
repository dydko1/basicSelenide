package com.dydko.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private static final String URL = "https://the-internet.herokuapp.com/login";

    private final SelenideElement pageHeader = $("h2");

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
