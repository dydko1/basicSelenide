package com.dydko.pages.older_1;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.dydko.pages.older_1.components.Table2Component;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class Iso2CountryPage {

    private final SelenideElement table = $("table");

    public List<Map<String, String>> get2All() {

        table.shouldBe(Condition.visible);
        ElementsCollection rows = table.$$("tbody tr")
                .shouldBe(CollectionCondition.sizeGreaterThan(100));

        return new Table2Component(table).parseTable();
    }
}
