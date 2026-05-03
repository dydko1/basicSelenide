package com.dydko.steps;

import com.dydko.mappers.UserMapper;
import com.dydko.pages.UsersPage;
import com.dydko.validators.UserValidator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class UsersSteps {
    private final UsersPage page = new UsersPage();

    @Given("I expected users")
    public void expected_users(DataTable table) {
        var expected = UserMapper.from(table);

        expected.forEach(exp -> {
            var actual = page.findByName(exp.getName());
            UserValidator.assertContains(actual, exp);
        });

    }
}
