package com.dydko.mappers;

import com.dydko.models.User;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class UserMapperTest {

    private final UserMapper mapper =
            new UserMapper();

    @Test
    void shouldMapUserDataToUser() {

        Map<String, String> data =
                Map.of(
                        "Last Name", "Smith123",
                        "First Name", "John",
                        "Email", "jsmith@gmail.com",
                        "Due", "$50.00",
                        "Web Site", "http://www.jsmith.com",
                        "Action", "edit delete"
                );

        User user = mapper.map(data);

        assertThat(user)
                .isEqualTo(
                        new User(
                                "Smith123",
                                "John",
                                "jsmith@gmail.com",
                                "$50.00",
                                "http://www.jsmith.com",
                                "edit delete"
                        )
                );
    }
}