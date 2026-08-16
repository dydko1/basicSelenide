package com.dydko.mappers;

import com.dydko.models.User;
import com.dydko.models.UserTableColumn;

import java.util.Map;

public class UserMapper {
    public User map(Map<String, String> data) {
        return new User(
                data.get(UserTableColumn.LAST_NAME.header()),
                data.get(UserTableColumn.FIRST_NAME.header()),
                data.get(UserTableColumn.EMAIL.header()),
                data.get(UserTableColumn.DUE.header()),
                data.get(UserTableColumn.WEB_SITE.header()),
                data.get(UserTableColumn.ACTION.header())
        );
    }
}