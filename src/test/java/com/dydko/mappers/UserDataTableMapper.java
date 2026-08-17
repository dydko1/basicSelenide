package com.dydko.mappers;

import com.dydko.models.User;

import java.util.Map;

public class UserDataTableMapper {

    public User map(Map<String, String> data) {
        return new User(data.get("lastName"),
                data.get("firstName"),
                data.get("email"),
                data.get("due"),
                data.get("webSite"),
                data.get("action")
        );
    }
}
