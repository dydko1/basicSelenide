package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserTableComponent extends TableComponent {

    public UserTableComponent(SelenideElement root) {

        super(root);
    }

    public List<Map<String, String>> getRows() {

        return root.$$("tbody tr")
                .stream()
                .map(this::extractRow)
                .toList();
    }

    private Map<String, String> extractRow(
            SelenideElement row) {

        List<String> headers =
                root.$$("thead th")
                        .texts();

        List<String> values =
                row.$$("td")
                        .texts();

        Map<String, String> result =
                new LinkedHashMap<>();

        for (int i = 0; i < headers.size(); i++) {

            result.put(
                    headers.get(i),
                    values.get(i)
            );
        }

        return result;
    }
}