package com.dydko.a_older;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Tut003LoginTest {

    @Test
    void shouldLoginSuccessfully() {
        open("https://practicetestautomation.com/practice-test-login/");
        $("#username").setValue("student");
        $("#password").setValue("Password123");
        $("#submit").click();
        $(".post-content")
                .shouldHave(textCaseSensitive("Congratulations student. You successfully logged in!"));
    }
}
