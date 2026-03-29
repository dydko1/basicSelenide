package com.dydko.data;

import java.util.Map;

public class TableData {

    private final String keyColumn;
    private final Map<String, Map<String, String>> rows;

    public TableData(String keyColumn, Map<String, Map<String, String>> rows) {
        this.keyColumn = keyColumn;
        this.rows = rows;
    }

    public String getKeyColumn() {
        return keyColumn;
    }

    public Map<String, Map<String, String>> getRows() {
        return rows;
    }
}