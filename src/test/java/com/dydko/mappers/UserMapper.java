package com.dydko.mappers;

import com.dydko.models.User;
import io.cucumber.datatable.DataTable;

import java.util.List;

import static com.dydko.constants.EmployeeColumns.*;

public class UserMapper {

    public static List<User> from(DataTable table) {

        return table.asMaps(String.class, String.class)
                .stream()
                .map(row -> new User(
                        row.get(NAME),
                        row.get(POSITION),
                        row.get(OFFICE),
                        row.get(START_DATE)))
                .toList();
    }
}
