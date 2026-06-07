package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Table2Component {

    private final SelenideElement table;

    public Table2Component(SelenideElement table) {
        this.table = table;
    }

    public List<Map<String, String>> parseTable() {

        List<String> headers = table.$$("thead th").texts();

        return table.$$("tbody tr").stream()
                .map(row -> {
                    List<String> cells = row.$$("td").texts();
                    return IntStream.range(0, cells.size())
                            .boxed()
                            .collect(Collectors.toMap(
                                    headers::get,
                                    i -> i < cells.size() ? cells.get(i) : "",
                                    (a, b) -> a,
                                    LinkedHashMap::new
                            ));

                })
                .collect(Collectors.toList());
    }
}
