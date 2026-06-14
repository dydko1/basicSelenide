package com.dydko.pages.older_1.components;

import com.codeborne.selenide.SelenideElement;
import com.dydko.models.older_1.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.$;
import static com.dydko.constants.older_1.EmployeeColumns.*;
import static com.dydko.constants.older_1.EmployeeColumns.START_DATE;

public class UsersTable {

    private final SelenideElement root = $("table");

    public List<User> rows() {
        List<String> headers = headers();
        return root.$$("tbody tr").stream()
                .map(tr -> toRowMap(headers, tr.$$("td").texts()))
                .map(this::toUser)
                .toList();
    }

    private List<String> headers() {
        return root.$$("thead th")
                .texts()
                .stream()
                .map(String::strip)
                .toList();
    }

    private Map<String, String> toRowMap(List<String> keys, List<String> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException("Keys and values must have same size");
        }

        return IntStream.range(0, keys.size())
                .mapToObj(i -> Map.entry(keys.get(i), values.get(i)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));
    }

    private User toUser(Map<String, String> row) {
        return new User(row.get(NAME),
                row.get(POSITION),
                row.get(OFFICE),
                row.get(START_DATE)
        );
    }
}
