package com.dydko.steps;

import com.dydko.mappers.UserMapper;
import com.dydko.models.User;
import com.dydko.pages.UsersPage;
import com.dydko.validators.UserValidator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;

public class UsersSteps {

    @Given("I expected users")
    public void expected_users(DataTable table){

        List<User> expected = UserMapper.from(table);

        UsersPage page = new UsersPage();

        // 🔥 najlepszy pattern: search per expected
        expected.forEach(exp -> {

            List<User> result = page.findByName(exp.getName());

            UserValidator.assertSubset(
                    List.of(exp),
                    result
            );
        });
    }
}
