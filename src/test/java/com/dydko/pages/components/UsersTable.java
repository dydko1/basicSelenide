package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.dydko.models.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.$;

public class UsersTable {

    private SelenideElement selenideElement = $("table");

    public List<User> getRows() {
        List<String> headers = selenideElement
                .$$("thead th")
                .texts()
                .stream()
                .map(String::strip)
                .toList();

        return selenideElement
                .$$("tbody tr").stream()
                .map(tr -> {
                    List<String> cells = tr.$$("td").texts();

                    Map<String, String> row =
                            IntStream.range(0, headers.size())
                                    .boxed()
                                    .collect(Collectors.toMap(headers::get,
                                            cells::get
                                    ));
                    return mapToUser(row);
                })
                .toList();
    }

    private User mapToUser(Map<String, String> row) {
        return new User(
                row.get("Name"),
                row.get("Position"),
                row.get("Office"),
                row.get("Start date")
        );
    }
}
