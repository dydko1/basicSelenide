package com.dydko.mappers;

import com.dydko.models.User;
import io.cucumber.datatable.DataTable;

import java.util.List;

public class UserMapper {

    public static List<User> from(DataTable table) {

        return table.asMaps(String.class, String.class)
                .stream()
                .map(row -> new User(
                        row.get("Name"),
                        row.get("Position"),
                        row.get("Office"),
                        row.get("Start date")
                ))
                .toList();
    }
}