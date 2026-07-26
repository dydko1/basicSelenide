package com.dydko.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;

public class UserTableLesson03Component extends TableLesson03Component {

    public UserTableLesson03Component(SelenideElement root) {
        super(root);
    }

    public int getRowCount() {
        return getRows().size();
    }

    public ElementsCollection getRowsCollection() {
        return getRows();
    }
}
