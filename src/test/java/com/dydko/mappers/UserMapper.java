package com.dydko.mappers;

import com.dydko.models.User;

import java.util.Map;

public class UserMapper {

    public User map(Map<String, String> row) {

        return new User(
                row.get("First Name"),
                row.get("Last Name"),
                row.get("Email"),
                row.get("Due"),
                row.get("Web Site")
        );
    }
}
