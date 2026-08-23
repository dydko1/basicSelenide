package com.dydko.pages;

import com.codeborne.selenide.SelenideElement;
import com.dydko.pages.components.UserTableComponent;

import static com.codeborne.selenide.Selenide.$;

public class UsersPage extends BasePage {

    private final UserTableComponent usersTable =
            new UserTableComponent($("table"));

    public UserTableComponent usersTable() {
        return usersTable;
    }

    @Override
    protected String url() {
        return "";
    }

    @Override
    protected SelenideElement pageIdentifier() {
        return null;
    }

    // url() i pageIdentifier()
}