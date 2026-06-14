package com.dydko.pages;

import com.dydko.pages.components.UserTableComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import com.dydko.pages.components.UserTableComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TablesPage extends BasePage {

    private static final String URL = "/tables";

    private final SelenideElement table1Root =
            $("#table1");

    private final SelenideElement table2Root =
            $("#table2");

    private final UserTableComponent table1 =
            new UserTableComponent(table1Root);

    private final UserTableComponent table2 =
            new UserTableComponent(table2Root);

    public TablesPage openPage() {

        open(URL);

        return this;
    }

    public UserTableComponent table1() {

        return table1;
    }

    public UserTableComponent table2() {

        return table2;
    }
}