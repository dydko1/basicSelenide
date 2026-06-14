package com.dydko.pages.older_1;

import com.dydko.models.older_1.CountryGDP;
import com.dydko.pages.older_1.components.CountryGDPTable;

import java.util.List;

public class CountryGDPPage {

    private final CountryGDPTable table = new CountryGDPTable();

    public List<CountryGDP> getAll() {
        return table.rows();
    }
}
