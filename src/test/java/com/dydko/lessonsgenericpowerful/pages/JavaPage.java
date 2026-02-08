package com.dydko.lessonsgenericpowerful.pages;

import static com.codeborne.selenide.Selenide.page;

public class WikipediaJavaPage {

    public WikipediaTabs tabs() {
        return page(WikipediaTabs.class);
    }
}
