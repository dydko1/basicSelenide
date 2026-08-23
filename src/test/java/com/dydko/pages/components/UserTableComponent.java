package com.dydko.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

public class UserTableComponent extends BaseComponent {

    public UserTableComponent(SelenideElement root) {
        super(root);
    }

    public List<String> getHeaders() {
        return root.$$("thead th")
                .texts();
    }

    public int getRowCount() {
        return root.$$("tbody tr")
                .size();
    }
}
