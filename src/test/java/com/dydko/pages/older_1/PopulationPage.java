package com.dydko.pages.older_1;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.dydko.pages.older_1.components.TableComponent;


import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class PopulationPage {

    private final SelenideElement table = $("table.datatable");

    public List<Map<String, String>> getAll() {
        table.shouldBe(Condition.visible);
        ElementsCollection rows = table.$$("tbody tr")
                .shouldBe(CollectionCondition.sizeGreaterThan(50));

        return new TableComponent(table).parseTable();
    }
}
