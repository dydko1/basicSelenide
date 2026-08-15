package com.dydko.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class TableLesson03Component extends BaseLesson03Component {

    protected TableLesson03Component(SelenideElement root) {
        super(root);
    }

    protected List<String> getHeaders() {
        return root.$$("thead td").texts();
    }

    protected ElementsCollection getRows() {
        return root.$$("tbody tr");
    }

    protected ElementsCollection getCells(SelenideElement row) {
        return row.$$("td");
    }

    protected SelenideElement getCell(SelenideElement row, int index) {
        return row.$$("td").get(index);
    }

    protected ElementsCollection getRowsContaining(String text) {
        return getRows()
                .filterBy(Condition.text(text));
    }

    public ElementsCollection getRowsContaining(String... conditions) {
        return getRows().filterBy(
                Condition.match(
                        "row contains all conditions",
                        row ->
                            Arrays.stream(conditions)
                                    .allMatch(condition -> row.getText().contains(condition))
                )
        );
    }
}