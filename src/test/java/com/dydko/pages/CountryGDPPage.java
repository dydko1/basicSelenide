package com.dydko.pages;

import com.dydko.models.CountryGDP;
import com.dydko.pages.components.CountryGDPTable;

import java.util.List;

public class CountryGDPPage {

    private final CountryGDPTable table = new CountryGDPTable();

    public List<CountryGDP> getAll() {
        return table.rows();
    }
}
