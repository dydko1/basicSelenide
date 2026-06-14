package com.dydko.mappers.older_1;

import com.dydko.models.older_1.Iso2Country;

import java.util.Map;

public class Iso2CountryMapper {

    public static Iso2Country map2(Map<String, String> row) {
        return new Iso2Country(
                row.get("Country"),
                row.get("Alpha-2 code"),
                row.get("Alpha-3 code"),
                row.get("Numeric")
        );
    }
}
