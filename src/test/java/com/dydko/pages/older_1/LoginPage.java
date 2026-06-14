package com.dydko.pages.older_1;

import lombok.extern.slf4j.Slf4j;


import static com.codeborne.selenide.Selenide.*;

@Slf4j
public class LoginPage {
    public void openUrl(String url) {
        open(url);
    }
}
