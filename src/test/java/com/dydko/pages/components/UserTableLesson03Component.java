package com.dydko.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Collection;

public class UserTableLesson03Component extends TableLesson03Component {

    public UserTableLesson03Component(SelenideElement root) {
        super(root);
    }

    public int getRowCount() {
        return getRows().size();
    }

    private ElementsCollection getRowsCollection() {
        return getRows();
    }

    public boolean isTableDisplayed() {
        return root.exists()
                && root.isDisplayed();
    }
}
