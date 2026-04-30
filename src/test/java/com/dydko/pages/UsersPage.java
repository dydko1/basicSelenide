package com.dydko.pages;


import com.dydko.models.User;
import com.dydko.pages.components.UsersTable;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class UsersPage {

    private final UsersTable table = new UsersTable();

    public List<User> findByName(String name){

        $(".dt-search input").clear();
        $(".dt-search input").setValue(name);

        $("table tbody").shouldHave(text(name)); // 🔥 najważniejsze

        return table.getRows();
    }

    public List<User> getAll(){
        return table.getRows();
    }
}
