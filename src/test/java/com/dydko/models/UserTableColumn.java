package com.dydko.models;

public enum UserTableColumn {

    LAST_NAME("Last Name"),
    FIRST_NAME("First Name"),
    EMAIL("Email"),
    DUE("Due"),
    WEB_SITE("Web Site"),
    ACTION("Action");

    private final String header;

    UserTableColumn(String header) {
        this.header = header;
    }

    public String header() {
        return header;
    }
}
