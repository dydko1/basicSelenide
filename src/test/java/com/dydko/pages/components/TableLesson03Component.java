package com.dydko.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class TableLesson03Component extends BaseLesson03Component {

    protected TableLesson03Component(SelenideElement root) {
        super(root);
    }

    protected ElementsCollection getRows() {
        return root.$$("tbody tr");
    }
}
