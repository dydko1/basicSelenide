package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class IsoCountryTable {

    private final SelenideElement table;

    public List<Map<String, String>> parseTable() {

        List<String> headers = table.$$("thead th").texts();

        return table.$$("tbody tr").stream()
                .map(row -> {
                    List<String> cells = row.$$("td").texts();
                    return IntStream.range(0, headers.size())
                            .boxed()
                            .collect(Collectors.toMap(
                                    headers::get, cells::get
                            ));
                })
                .toList();
    }
}