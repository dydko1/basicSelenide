package com.dydko.lessonsgenericpowerful.pages;

import static com.codeborne.selenide.Selenide.page;

public class JavaPage {

    public ArticleTabs tabs() {
        return page(ArticleTabs.class);
    }
}
