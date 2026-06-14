package com.dydko.pages.older_1.components;

import com.codeborne.selenide.*;
import com.dydko.models.older_1.CountryGDP;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;

public class CountryGDPTable {

    // -------------------------------
    // PUBLIC API
    // -------------------------------

    public List<CountryGDP> rows() {

        List<String> headers = headers();

        root().$$("tbody tr")
                .shouldHave(sizeGreaterThan(10));

        return root().$$("tbody tr").stream()
                .filter(tr -> tr.$$("td").size() == headers.size())
                .map(tr -> toRowMap(headers, tr.$$("td").texts()))
                .map(this::toCountryGDP)
                .toList();
    }

    // -------------------------------
    // ROOT (LAZY)
    // -------------------------------

    private SelenideElement root() {
        return findTableWithImf().shouldBe(visible);
    }

    // -------------------------------
    // TABLE FINDER
    // -------------------------------

    private SelenideElement findTableWithImf() {
        return $$("table.wikitable")
                .stream()
                .filter(table ->
                        table.$$("thead th")
                                .texts()
                                .stream()
                                .map(this::cleanHeader)
                                .anyMatch(h -> h.toUpperCase().startsWith("IMF"))
                )
                .findFirst()
                .orElseThrow(() ->
                        new AssertionError("Table with IMF column not found"));
    }

    // -------------------------------
    // HEADERS
    // -------------------------------

    private List<String> headers() {
        return root().$$("thead th")
                .texts()
                .stream()
                .map(this::cleanHeader)
                .toList();
    }

    // -------------------------------
    // MAPPING
    // -------------------------------

    private Map<String, String> toRowMap(List<String> keys, List<String> values) {
        return IntStream.range(0, keys.size())
                .mapToObj(i -> Map.entry(keys.get(i), values.get(i)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> b,
                        LinkedHashMap::new
                ));
    }

    private CountryGDP toCountryGDP(Map<String, String> row) {
        return new CountryGDP(
                cleanText(findValue(row, "Country")),
                normalizeNumber(findValue(row, "IMF")),
                normalizeNumber(findValue(row, "World Bank")),
                normalizeNumber(findValue(row, "UN"))
        );
    }

    // -------------------------------
    // SMART COLUMN RESOLUTION
    // -------------------------------

    private String findValue(Map<String, String> row, String column) {
        return row.entrySet().stream()
                .filter(e -> cleanHeader(e.getKey())
                        .toUpperCase()
                        .startsWith(column.toUpperCase()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse("");
    }

    // -------------------------------
    // CLEANING
    // -------------------------------

    private String cleanHeader(String text) {
        return text
                .replaceAll("\\[.*?]", "") // usuń przypisy [1]
                .strip();
    }

    private String cleanText(String text) {
        return text
                .replaceAll("\\[.*?]", "")
                .strip();
    }

    private String normalizeNumber(String text) {
        return text
                .replaceAll("\\[.*?]", "")
                .replaceAll("[,\\s]", "")   // usuń przecinki i spacje
                .replaceAll("–|—", "")      // brak danych
                .strip();
    }

    private static String normalize(String value) {
        return value == null ? null :
                value.replaceAll("[,\\s]", "").strip();
    }
}