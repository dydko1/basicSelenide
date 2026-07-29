package com.dydko.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.dydko.parsers.TableLesson08Parser;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;

public class UserTableLesson07Component extends TableLesson03Component {

    private final TableLesson08Parser parser =
            new TableLesson08Parser();

    public UserTableLesson07Component(SelenideElement root) {
        super(root);
    }

    public int getRowCount() {
        return getRows().size();
    }

    public SelenideElement getUserRow(String lastName) {
        return getRows()
                .findBy(text(lastName));
    }

    public String getEmail(String lastName) {
        return getUserData(lastName)
                .get("Email");
    }

    public String getFirstName(String lastName) {
        return getUserData(lastName).get("First Name");
    }

    public String getWebsite(String lastName) {
        return getUserData(lastName)
                .get("Web Site");
    }

//    public String getDue(String lastName) {
//        return getCell(getUserRow(lastName), 3)
//                .getText();
//    }

    public Map<String, String> getUserData(String lastName) {
        return parser.parse(getHeaders(), getUserRow(lastName));
    }
}