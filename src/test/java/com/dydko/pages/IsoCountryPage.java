package com.dydko.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.dydko.pages.components.IsoCountryTable;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class IsoCountryPage {

    private final SelenideElement table = $("table");

    public List<Map<String, String>> getAll() {
        table.shouldBe(Condition.visible);
        ElementsCollection rows = table.$$("tbody tr")
                .shouldBe(CollectionCondition.sizeGreaterThan(100));
        return new IsoCountryTable(table).parseTable();
    }
}
