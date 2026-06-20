package com.dydko.pages;

import com.codeborne.selenide.SelenideElement;
import com.dydko.pages.components.UserTableComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TablesLesson02Page extends BasePage {

    private static final String URL =
            "https://the-internet.herokuapp.com/tables";

    private final SelenideElement pageHeader =
            $x("//h3");

    private final UserTableComponent userTable =
            new UserTableComponent(
                    $("#table1"));

    @Override
    protected String getUrl() {
        return URL;
    }

    @Override
    protected SelenideElement getPageIdentifier() {
        return pageHeader;
    }

    public String getPageTitle() {
        return getPageIdentifier().getText();
    }

    public UserTableComponent getUserTable() {
        return userTable;
    }
}
