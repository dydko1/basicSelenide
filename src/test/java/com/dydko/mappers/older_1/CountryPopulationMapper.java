package com.dydko.mappers.older_1;

import com.dydko.models.older_1.CountryPopulation;

import java.util.Map;

public class CountryPopulationMapper {

    public static CountryPopulation map(Map<String, String> row) {

        return new CountryPopulation(
                row.get("Country (or dependency)"), // edge case!
                row.get("Population 2026"),
                row.get("Yearly Change"),
                row.get("Density (P/Km²)")
        );
    }
}
