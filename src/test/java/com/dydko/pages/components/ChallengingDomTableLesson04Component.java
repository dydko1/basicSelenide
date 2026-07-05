package com.dydko.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class ChallengingDomTableLesson04Component extends TableLesson03Component {
    public ChallengingDomTableLesson04Component(SelenideElement root) {
        super(root);
    }

    public int getRowCount() {
        return getRows().size();
    }

    public ElementsCollection getRowsCollections() {
        return getRows();
    }
}
