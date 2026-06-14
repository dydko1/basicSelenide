package com.dydko.mappers.older_1;

import com.dydko.models.older_1.IsoCountry;

import java.util.Map;

public class IsoCountryMapper {

    public static IsoCountry map(Map<String, String> row) {

        return new IsoCountry(
                row.get("Country"),
                row.get("Alpha-2 code"),
                row.get("Alpha-3 code"),
                row.get("Numeric")
        );
    }
}
