package com.dydko.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;

public class ChallengingDomTableLesson04Component extends TableLesson03Component {

    public ChallengingDomTableLesson04Component(SelenideElement root) {
        super(root);
    }

    public int getRowCount() {
        return getRows().size();
    }

    public ElementsCollection getRowsCollection() {
        return getRows();
    }

    public SelenideElement getRowByLastName(String lastName) {
        return getRows()
                .findBy(text(lastName));
    }

    public boolean containsUser(String lastName) {
        return getRowByLastName(lastName)
                .exists();
    }

    public int getUsersCount() {
        return getRows().size();
    }
}
