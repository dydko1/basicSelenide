package com.dydko.pages;

import com.codeborne.selenide.SelenideElement;
import com.dydko.pages.components.UserTableLesson03Component;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class TablesLesson02Page extends BasePage {

    private static final String URL =
            "https://the-internet.herokuapp.com/tables";

    private final SelenideElement pageHeader = $("h3");

    private UserTableLesson03Component userTable = new UserTableLesson03Component($("#table1"));

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
