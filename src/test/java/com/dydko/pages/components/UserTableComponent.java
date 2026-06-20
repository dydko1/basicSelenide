package com.dydko.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class UserTableComponent extends TableComponent {

    public UserTableComponent(SelenideElement root) {
        super(root);
    }

    public int getRowCount() {
        return getRows().size();
    }

    public ElementsCollection getRowsCollection() {
        return getRows();
    }
}