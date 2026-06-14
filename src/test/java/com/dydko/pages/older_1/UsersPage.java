package com.dydko.pages.older_1;

import com.codeborne.selenide.SelenideElement;
import com.dydko.models.older_1.User;
import com.dydko.pages.older_1.components.UsersTable;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class UsersPage {

    private SelenideElement search = $(".dt-search input");
    private final UsersTable table = new UsersTable();

    public List<User> findByName(String name) {
        search.clear();
        search.setValue(name);
        $("table tbody").shouldHave(text(name));
        return table.rows();
    }
}
