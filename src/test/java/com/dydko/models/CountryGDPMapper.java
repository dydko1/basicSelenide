package com.dydko.models;

import io.cucumber.datatable.DataTable;

import java.util.List;

import static com.dydko.constants.CountryGDPColumns.*;

public class CountryGDPMapper {

    public static List<CountryGDP> from(DataTable table) {
        return table.asMaps(String.class, String.class)
                .stream()
                .map(row -> new CountryGDP(
                        normalizeText(row.get(COUNTRY)),
                        normalizeNumber(row.get(IMF)),
                        normalizeNumber(row.get(WORLD_BANK)),
                        normalizeNumber(row.get(UN))
                ))
                .toList();
    }

    // -------------------------------
    // NORMALIZATION
    // -------------------------------

    private static String normalizeText(String value) {
        return value == null ? "" :
                value.replaceAll("\\[.*?]", "") // usuń przypisy [1]
                        .strip();
    }

    private static String normalizeNumber(String value) {
        if (value == null) return "";

        return value
                .replaceAll("\\[.*?]", "") // usuń przypisy
                .replaceAll("[,\\s]", "")  // usuń przecinki i spacje
                .replaceAll("–|—", "")     // brak danych
                .strip();
    }
}