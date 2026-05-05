package com.dydko.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TableComponent {

    private final SelenideElement table;

    public TableComponent(SelenideElement table) {
        this.table = table;
    }

    public List<Map<String, String>> parseTable() {

        // headers
        List<String> headers = table.$$("thead th")
                .texts();

        // rows
        return table.$$("tbody tr").stream()
                .map(row -> {
                    List<String> cells = row.$$("td").texts();

                    return IntStream.range(0, headers.size())
                            .boxed()
                            .collect(Collectors.toMap(
                                    headers::get,
                                    i -> i < cells.size() ? cells.get(i) : "",
                                    (a, b) -> a,
                                    LinkedHashMap::new // zachowujemy kolejność
                            ));
                })
                .collect(Collectors.toList());
    }
}