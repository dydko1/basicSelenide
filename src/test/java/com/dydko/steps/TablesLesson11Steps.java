package com.dydko.steps;

import com.dydko.mappers.UserDataTableMapper;
import com.dydko.models.User;
import com.dydko.pages.TablesLesson07Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TablesLesson11Steps {

    private final TablesLesson07Page tablesPage =
            new TablesLesson07Page();

    private final UserDataTableMapper mapper =
            new UserDataTableMapper();

    @Then("users should match:")
    public void usersShouldMatch(DataTable dataTable) {
        List<User> expectedUsers =
                dataTable.asMaps()
                        .stream()
                        .map(mapper::map)
                        .toList();
        List<User> actualUsers =
                expectedUsers.stream()
                        .map(user ->
                                tablesPage
                                        .getTable()
                                        .getUser(
                                                user.lastName()
                                        )
                        )
                        .toList();
        assertThat(actualUsers)
                .containsExactlyElementsOf(expectedUsers);
    }
}
