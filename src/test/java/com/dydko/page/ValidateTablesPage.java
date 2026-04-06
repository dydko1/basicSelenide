package com.dydko.page;

import com.codeborne.selenide.SelenideElement;
import com.dydko.data.TableData1;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ValidateTablesPage {

    private final SelenideElement table = $("#table1");

    public TableData1 getTable() {
        List<String> headers = table
                .shouldBe(visible)
                .$$("thead th")
                .shouldHave(sizeGreaterThan(1))
                .texts();

        String keyColumn = headers.get(0);

        // !! QA Automation z Cucumber !!
        return null;
    }
}
