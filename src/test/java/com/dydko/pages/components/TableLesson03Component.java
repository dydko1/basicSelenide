package com.dydko.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

public class TableLesson03Component extends BaseLesson03Component {

    protected TableLesson03Component(SelenideElement root) {
        super(root);
    }

    protected ElementsCollection getRows() {
        return root.$$("tbody tr");
    }

    protected List<String> getHeaders() {
        return root.$$("thead th")
                .texts();
    }

    protected ElementsCollection getCells(SelenideElement row) {
        return row.$$("td");
    }

    protected SelenideElement getCell(SelenideElement row, int index) {
        return getCells(row)
                .get(index);

    }
}

