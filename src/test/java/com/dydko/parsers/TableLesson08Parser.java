package com.dydko.parsers;

import com.codeborne.selenide.SelenideElement;

import java.util.*;

public class TableLesson08Parser {

    public Map<String, String> parse(List<String> headers, SelenideElement row) {

        List<String> values = row.$$("td").texts();

        if (headers.size() != values.size()) {
            throw new IllegalStateException("headers and values are not equal");
        }

        Map<String, String> result = new LinkedHashMap<>();

        for (int i = 0; i < headers.size(); i++) {
            result.put(headers.get(i), values.get(i));
        }

        return result;
    }
}
