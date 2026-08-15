package com.dydko.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.dydko.parsers.TableLesson08Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserTableLesson07Component extends TableLesson03Component {

    private final TableLesson08Parser parser = new TableLesson08Parser();

    public UserTableLesson07Component(SelenideElement root) {
        super(root);
    }

    public int getRowCount() {
        return getRows().size();
    }

    public SelenideElement getUserRow(String lastName) {
        return getRows()
                .findBy(Condition.text(lastName));
    }

    public String getEmail(String lastName) {
        return getUserData(lastName)
                .get("Email");
    }

    public String getFirstName(String lastName) {
        return getUserData(lastName)
                .get("First Name");

    }

    public String getWebsite(String lastName) {
        return getUserData(lastName)
                .get("Web Site");
    }

    public boolean userExists(String lastName) {
        return getUserRow(lastName).exists();
    }

    private Map<String, String> getUserData(String lastName) {
        return parser.parse(getHeaders(), getUserRow(lastName));
    }

    public List<List<String>> getRowsTextsContaining(String text) {
        return getRowsContaining(text)
                .asFixedIterable()
                .stream()
                .map(row -> row.$$("td").texts())
                .toList();
    }

    public List<List<String>> getRowsTextsContaining(List<String> conditions) {

        List<List<String>> result = new ArrayList<>();

        for (SelenideElement row : getRows()) {

            boolean matches = conditions.stream()
                    .allMatch(condition ->
                            row.getText().contains(condition)
                    );

            if (matches) {
                result.add(row.$$("td").texts());
            }
        }

        return result;
    }
}