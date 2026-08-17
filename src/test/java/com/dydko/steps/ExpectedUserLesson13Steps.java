package com.dydko.steps;

import com.dydko.mappers.UserDataTableMapper;
import com.dydko.models.User;
import com.dydko.testsupport.ScenarioContext;
import com.dydko.testsupport.TestContextKey;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.Map;

public class ExpectedUserLesson13Steps {

    private final UserDataTableMapper mapper =
            new UserDataTableMapper();

    @And("expected user is:")
    public void expectedUserIs(
            DataTable dataTable) {

        Map<String, String> data =
                dataTable
                        .asMaps()
                        .get(0);

        User expectedUser =
                mapper.map(data);

        ScenarioContext
                .get()
                .set(
                        TestContextKey.EXPECTED_USER,
                        expectedUser
                );
    }
}
